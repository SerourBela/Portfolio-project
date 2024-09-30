package com.serour.ranamaeak.memorygame.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

import com.serour.ranamaeak.memorygame.common.Shared;

public class Utils {

	public static int px(int dp) {
		return (int) (Shared.context.getResources().getDisplayMetrics().density * dp);
	}

	public static Bitmap scaleDown(int resource) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(Shared.context.getResources(), resource);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(Shared.context.getResources(), resource, options);
	}
	public static Bitmap downscaleBitmap(Bitmap wallpaper, int factor) {
		// convert to bitmap and get the center
		int widthPixels = wallpaper.getWidth() / factor;
		int heightPixels = wallpaper.getHeight() / factor;
		return ThumbnailUtils.extractThumbnail(wallpaper, widthPixels, heightPixels);
	}

}
