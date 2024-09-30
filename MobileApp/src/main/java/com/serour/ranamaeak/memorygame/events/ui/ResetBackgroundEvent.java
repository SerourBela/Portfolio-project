package com.serour.ranamaeak.memorygame.events.ui;


import com.serour.ranamaeak.memorygame.events.AbstractEvent;
import com.serour.ranamaeak.memorygame.events.EventObserver;

public class ResetBackgroundEvent extends AbstractEvent {

	public static final String TYPE = ResetBackgroundEvent.class.getName();

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
