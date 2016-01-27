package com.tisquare.slideshow.activity;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Myeongho on 2015-08-19.
 */
public class TestActivity extends Activity {
	SurfaceView sv;
	SurfaceHolder holder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		sv = new SurfaceView(this);
		holder = sv.getHolder();
		holder.addCallback(new SVCallBack());
	}

	class SVThread extends Thread {
		@Override
		public void run() {
			// TODO : draw bitmap
			Canvas c = holder.lockCanvas(null);
			c.drawColor(Color.BLUE);
			holder.unlockCanvasAndPost(c);
			// TODO : n sec wait
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class SVCallBack implements SurfaceHolder.Callback {

		@Override
		public void surfaceCreated(SurfaceHolder holder) {

		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {

		}
	}

}
