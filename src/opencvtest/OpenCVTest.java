package opencvtest;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.objdetect.CascadeClassifier;

public class OpenCVTest {
	public static void main(String[] args){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		/*
		// 入力画像の取得	
		Mat im = Imgcodecs.imread("test.png"); 
		// カスケード分類器でアニメ顔探索
		CascadeClassifier faceDetector = new CascadeClassifier("lbpcascade_animeface.xml");
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(im, faceDetections);
		// 見つかったアニメ顔を矩形で囲む

		int cnt = 1;

		for (Rect rect : faceDetections.toArray()) {
			Mat im2 = new Mat(im, rect);
			String name = (cnt < 10) ? "00"+ cnt : (cnt < 100) ? "0" + cnt : "" + cnt;
			Imgcodecs.imwrite("anime" + name + ".png", im2);
			System.out.println("ok");
			cnt++;

			Imgproc.rectangle(im, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 5);
		}
		// 結果を保存
		//	        Imgcodecs.imwrite("anime.png", im);
		 * 
		 */
		
		File imageDir = new File("lovelive!");
//		String[] files = imageDir.list();
		File[] files = imageDir.listFiles();
		
		int cnt = 1;
		for(int i = 0; i < files.length; i++){
			Mat im = Imgcodecs.imread("lovelive!/" + files[i].getName());
			CascadeClassifier faceDetector = new CascadeClassifier("lbpcascade_animeface.xml");
			MatOfRect faceDetections = new MatOfRect();
			faceDetector.detectMultiScale(im, faceDetections);
			
			for(Rect rect : faceDetections.toArray()){
				Mat im2 = new Mat(im, rect);
				String name = (cnt < 10) ? "00" + cnt : (cnt < 100) ? "0" + cnt : "" + cnt;
				Imgcodecs.imwrite("lovelive!_face/face" + name + ".png", im2);
				cnt++;
				
				Imgproc.rectangle(im, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 5);
			}
			
			Imgcodecs.imwrite("_" + files[i].getName(), im);
		}
	}
}