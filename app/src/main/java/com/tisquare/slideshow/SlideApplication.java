package com.tisquare.slideshow;

import android.app.Application;
import android.graphics.Bitmap;

import com.tisquare.slideshow.draw.SlideShow;

import java.util.ArrayList;

/**
 * Created by Myeongho on 2015-08-01.
 */
public class SlideApplication extends Application {
	public static String BGM_PATH = "";
	public static int SLIDE_TIME = 2;
	public static int SLIDE_EFFECT = SlideShow.NONE;
	public static int BIT_RATE = 500 * 1024;
	public static int FRAME_PER_SEC = 30;
	public static ArrayList<Bitmap> bitmapList = new ArrayList<>();
}
