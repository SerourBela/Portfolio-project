package com.serour.ranamaeak;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

import com.serour.ranamaeak.memorygame.common.Shared;
import com.serour.ranamaeak.memorygame.engine.Engine;
import com.serour.ranamaeak.memorygame.engine.ScreenController;
import com.serour.ranamaeak.memorygame.events.EventBus;
import com.serour.ranamaeak.memorygame.utils.Utils;


public class MemoryLevels extends FragmentActivity {

	private ImageView mBackgroundImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Shared.context = getApplicationContext();
		Shared.engine = Engine.getInstance();
		Shared.eventBus = EventBus.getInstance();

		setContentView(R.layout.activity_memorylevels);
		mBackgroundImage =  findViewById(R.id.background_image);

		Shared.activity = this;
		Shared.engine.start();
		Shared.engine.setBackgroundImageView(mBackgroundImage);
		setBackgroundImage();
		ScreenController.getInstance().openScreen(ScreenController.Screen.MENU);
	}


	private void setBackgroundImage() {
		Bitmap bitmap = Utils.scaleDown(R.drawable.background);
		bitmap = Utils.downscaleBitmap(bitmap, 2);
		mBackgroundImage.setImageBitmap(bitmap);
	}

}