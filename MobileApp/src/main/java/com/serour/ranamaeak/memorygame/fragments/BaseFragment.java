package com.serour.ranamaeak.memorygame.fragments;


import androidx.fragment.app.Fragment;

import com.serour.ranamaeak.memorygame.events.EventObserver;
import com.serour.ranamaeak.memorygame.events.engine.FlipDownCardsEvent;
import com.serour.ranamaeak.memorygame.events.engine.GameWonEvent;
import com.serour.ranamaeak.memorygame.events.engine.HidePairCardsEvent;
import com.serour.ranamaeak.memorygame.events.ui.BackGameEvent;
import com.serour.ranamaeak.memorygame.events.ui.DifficultySelectedEvent;
import com.serour.ranamaeak.memorygame.events.ui.FlipCardEvent;
import com.serour.ranamaeak.memorygame.events.ui.NextGameEvent;
import com.serour.ranamaeak.memorygame.events.ui.ResetBackgroundEvent;
import com.serour.ranamaeak.memorygame.events.ui.StartEvent;
import com.serour.ranamaeak.memorygame.events.ui.ThemeSelectedEvent;

public class BaseFragment extends Fragment implements EventObserver {

	@Override
	public void onEvent(FlipCardEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(DifficultySelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(HidePairCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(FlipDownCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(StartEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ThemeSelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(GameWonEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(BackGameEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(NextGameEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ResetBackgroundEvent event) {
		throw new UnsupportedOperationException();
	}

}
