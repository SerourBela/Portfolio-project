package com.serour.ranamaeak.memorygame.model;

import android.graphics.Bitmap;

import com.serour.ranamaeak.memorygame.common.Shared;
import com.serour.ranamaeak.memorygame.themes.Themes;
import com.serour.ranamaeak.memorygame.utils.Utils;

import java.util.Map;

public class BoardArrangment {

	public Map<Integer, Integer> pairs;
	public Map<Integer, String> tileUrls;

	public Bitmap getTileBitmap(int id, int size) {
		String string = tileUrls.get(id);
		if (string.contains(Themes.URI_DRAWABLE)) {
			String drawableResourceName = string.substring(Themes.URI_DRAWABLE.length());
			int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
			Bitmap bitmap = Utils.scaleDown(drawableResourceId);
			return bitmap;
		}
		return null;
	}

	public boolean isPair(int id1, int id2) {
		Integer integer = pairs.get(id1);
		if (integer == null) {
			return false;
		}
		return integer.equals(id2);
	}

}
