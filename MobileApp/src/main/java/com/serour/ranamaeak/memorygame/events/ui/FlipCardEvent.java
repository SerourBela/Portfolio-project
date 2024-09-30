package com.serour.ranamaeak.memorygame.events.ui;


import com.serour.ranamaeak.memorygame.events.AbstractEvent;
import com.serour.ranamaeak.memorygame.events.EventObserver;

public class FlipCardEvent extends AbstractEvent {

	public static final String TYPE = FlipCardEvent.class.getName();

	public final int id;
	
	public FlipCardEvent(int id) {
		this.id = id;
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
