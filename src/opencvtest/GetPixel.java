package opencvtest;

/*
 * 入力画像の指定したピクセルの画素値を取得
 */

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class GetPixel {
	
	public static void main(String[] args){
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat im = Imgcodecs.imread("test.jpg"); // 入力画像の取得
		
//		double[] data = new double[3]; // BGRデータ
//		data = im.get(100, 200); // 取得するピクセルを指定(col, row)(列，行)
//		System.out.println("Blue: " + data[0]);
//		System.out.println("Green: " + data[1]);
//		System.out.println("Red: " + data[2]);
		
		double blue_min = 255.0;
		double blue_max = 0.0;
		double green_min = 255.0;
		double green_max = 0.0;
		double red_min = 255.0;
		double red_max = 0.0;
		
		for(int i = 0; i < im.rows(); i++){
			for(int j = 0; j < im.cols(); j++){
				double[] data = im.get(i, j);
				System.out.println("(" + i + "," + j + ") blue: " + data[0] + " green: " + data[1] + " red: " + data[2]); 
				if(data[0] < blue_min){
					blue_min = data[0];
				}
				if(data[0] > blue_max){
					blue_max = data[0];
				}
				if(data[1] < green_min){
					green_min = data[1];
				}
				if(data[1] > green_max){
					green_max = data[1];
				}
				if(data[2] < red_min){
					red_min = data[2];
				}
				if(data[2] > red_max){
					red_max = data[2];
				}
			}
		}
		
		System.out.println("blue_min: " + blue_min);
		System.out.println("blue_max: " + blue_max);
		System.out.println("green_min: " + green_min);
		System.out.println("green_max: " + green_max);
		System.out.println("red_min: " + red_min);
		System.out.println("red_max: " + red_max);
		
	}

}
