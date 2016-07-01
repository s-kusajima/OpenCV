package opencvtest;

import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;

public class MovieTest {
	
	public static void main(String[] args){
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture cap = new VideoCapture();
		cap.open("kkk.mp4");
		
		if(cap.isOpened()){
			System.out.println("unko");
		}else{
			System.out.println("not unko");
		}
		
		cap.release();
	}
	
}
