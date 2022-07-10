package com.jfacedetection;

import org.opencv.core.Core;

import org.opencv.core.Mat;

import org.opencv.core.MatOfRect;

import org.opencv.core.Point;

import org.opencv.core.Rect;

import org.opencv.core.Scalar;

import org.opencv.imgcodecs.Imgcodecs;

import org.opencv.imgproc.Imgproc;

import org.opencv.objdetect.CascadeClassifier;


public class JFaceDetection 
{
	public static void main(String [] args) 
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		String imgfile="image/img1.jpg";
		
		Mat src =Imgcodecs.imread(imgfile);
		
		String xmlfile="xml/lbpcascade_frontalface.xml";
		
		CascadeClassifier cc= new CascadeClassifier(xmlfile);
		
		MatOfRect faceDetection = new MatOfRect();
		
		cc.detectMultiScale(src, faceDetection);
		
		System.out.println(String.format("Detected faces:%d",faceDetection.toArray().length));
		
		for ( Rect rect: faceDetection.toArray() )
		{
		Imgproc.rectangle(src, new Point(rect.x, rect.y),new Point(rect.x + rect.width,rect.y + rect.height),new Scalar(0, 255, 0),3);

		}
		Imgcodecs.imwrite("image/img1.jpg", src);
		System.out.print("Face Detected");

	}
}
