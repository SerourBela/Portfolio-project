package com.serour.ranamaeak.memorygame.events.engine;


import com.serour.ranamaeak.memorygame.events.AbstractEvent;
import com.serour.ranamaeak.memorygame.events.EventObserver;
import com.serour.ranamaeak.memorygame.model.GameState;

public class GameWonEvent extends AbstractEvent {

	public static final String TYPE = GameWonEvent.class.getName();

	public GameState gameState;

	
	public GameWonEvent(GameState gameState) {
		this.gameState = gameState;
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
