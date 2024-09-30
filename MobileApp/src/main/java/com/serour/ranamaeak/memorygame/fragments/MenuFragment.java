package com.serour.ranamaeak.memorygame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.serour.ranamaeak.R;
import com.serour.ranamaeak.memorygame.common.Shared;
import com.serour.ranamaeak.memorygame.events.ui.ThemeSelectedEvent;
import com.serour.ranamaeak.memorygame.themes.Theme;
import com.serour.ranamaeak.memorygame.themes.Themes;

public class MenuFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.menu_fragment, container, false);

		final Theme themeAnimals = Themes.createAnimalsTheme();
		Shared.eventBus.notify(new ThemeSelectedEvent(themeAnimals));

		return view;
	}
}
