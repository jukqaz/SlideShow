package com.tisquare.slideshow.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tisquare.slideshow.R;

import nl.changer.polypicker.Config;
import nl.changer.polypicker.ImagePickerActivity;

public class MainActivity extends Activity implements View.OnClickListener {
	private static final int INTENT_REQUEST_GET_IMAGES = 109;
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnCreate = (Button) findViewById(R.id.btn_create);

		btnCreate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_create:
				getImages();
				break;
			default:
				break;
		}
	}

	private void getImages() {
		Intent intent = new Intent(getApplicationContext(), ImagePickerActivity.class);
		Config config = new Config.Builder()
				.setTabBackgroundColor(R.color.white)    // set tab background color. Default white.
				.setTabSelectionIndicatorColor(R.color.blue)
				.setCameraButtonColor(R.color.green)
				.build();
		ImagePickerActivity.setConfig(config);
		startActivityForResult(intent, INTENT_REQUEST_GET_IMAGES);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		if (resultCode == Activity.RESULT_OK) {
			if (requestCode == INTENT_REQUEST_GET_IMAGES) {
				Parcelable[] parcelableUris = intent.getParcelableArrayExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);

				if (parcelableUris == null) {
					return;
				}

				if (parcelableUris.length > 0) {
					Intent i = new Intent(getApplicationContext(), EffectActivity.class);
					i.putExtra("parcelableUris", parcelableUris);
					startActivity(i);
				} else {
					Toast.makeText(getApplicationContext(), "선택된 사진이 없습니다.", Toast.LENGTH_SHORT).show();
				}
			}
		} else {
			Toast.makeText(getApplicationContext(), "사진선택이 취소됐습니다.", Toast.LENGTH_SHORT).show();
		}
	}
}