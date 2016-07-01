package opencvtest;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class MakeOtherImage {
	
	public MakeOtherImage(String imagePath){
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat im1 = Imgcodecs.imread(imagePath);
		Mat im2 = new Mat(im1.rows(), im1.cols(), CvType.CV_8UC3);
		
//		System.out.println(im1);
		
		for(int i = 0; i < im1.rows(); i++){
			for(int j = 0; j < im1.cols(); j++){
				double[] d = im1.get(i, j);
				d = convertPixel(d);
				im2.put(i, j, d);
			}
		}
		
		Imgcodecs.imwrite("test3.jpg", im2);
		
		
		
	}
	
	public double[] convertPixel(double[] d){
		
		if(d.length != 3) return d;
		
		double blue = convertNum_4(d[0]);
		double green = convertNum_4(d[1]);
		double red = convertNum_4(d[2]);
		
		double[] d2 = {blue, green, red};
		
		return d2;
	}
	
	public double convertNum_8(double d){
		
		if(d < 32.0){
			return 16.0;
		}else if(d < 64.0){
			return 48.0;
		}else if(d < 96.0){
			return 80.0;
		}else if(d < 128.0){
			return 112.0;
		}else if(d < 160.0){
			return 144.0;
		}else if(d < 192.0){
			return 176.0;
		}else if(d < 224.0){
			return 208.0;
		}else{
			return 240.0;
		}
	}
	
	public double convertNum_4(double d){
		
		if(d < 64.0){
			return 32.0;
		}else if(d < 128.0){
			return 96.0;
		}else if(d < 192.0){
			return 160.0;
		}else{
			return 224.0;
		}
	}
	
	public static void main(String[] args){
		
		new MakeOtherImage("test.jpg");
		
	}

}
