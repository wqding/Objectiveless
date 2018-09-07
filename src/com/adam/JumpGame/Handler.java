package com.adam.JumpGame;

import com.adam.JumpGame.input.KeyManager;
import com.adam.JumpGame.worlds.GameCamera;
import com.adam.JumpGame.worlds.World;

public class Handler {

	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public World getWorld() {
		return world;
	}



	public void setWorld(World world) {
		this.world = world;
	}



	public int getWidth() {
		return game.width;
	}
	
	public int getHeight() {
		return game.height;
	}
	
	public GameCamera getGc() {
		return game.getGc();
	}
	
	public KeyManager getKm() {
		return game.getKm();
	}

	public void setKm(KeyManager km) {
		game.setKm(km);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
