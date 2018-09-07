	 package com.adam.JumpGame.states;

import java.awt.Graphics;

import com.adam.JumpGame.Handler;

public abstract class State {
	//StateManager class
	private static State currentState = null;

	public static void setCurrentState(State state) {
		currentState = state;
	}

	public static State getCurrentState() {
		return currentState;
	}

	//State class
	
	protected Handler handler;
	
	public State(Handler handler) {
		//giving this class access to the handler obj that is passed into it when gameState is initiallized in the Game class
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
