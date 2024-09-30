package com.serour.ranamaeak.memorygame.events.ui;

import com.serour.ranamaeak.memorygame.events.AbstractEvent;
import com.serour.ranamaeak.memorygame.events.EventObserver;
import com.serour.ranamaeak.memorygame.themes.Theme;

public class ThemeSelectedEvent extends AbstractEvent {

	public static final String TYPE = ThemeSelectedEvent.class.getName();
	public final Theme theme;

	public ThemeSelectedEvent(Theme theme) {
		this.theme = theme;
	}

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
