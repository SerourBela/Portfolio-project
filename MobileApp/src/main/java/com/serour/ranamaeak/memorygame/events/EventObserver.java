package com.serour.ranamaeak.memorygame.events;

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

public interface EventObserver {

	void onEvent(FlipCardEvent event);

	void onEvent(DifficultySelectedEvent event);

	void onEvent(HidePairCardsEvent event);

	void onEvent(FlipDownCardsEvent event);

	void onEvent(StartEvent event);

	void onEvent(ThemeSelectedEvent event);

	void onEvent(GameWonEvent event);

	void onEvent(BackGameEvent event);

	void onEvent(NextGameEvent event);

	void onEvent(ResetBackgroundEvent event);

}
