package com.adam.JumpGame.states;

import java.awt.Graphics;

import com.adam.JumpGame.Handler;
import com.adam.JumpGame.entities.Player;
import com.adam.JumpGame.tiles.Tile;
import com.adam.JumpGame.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	//private gc GameCamera;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/maps/map1.txt");
		handler.setWorld(world);
		player = new Player(handler, 2*Tile.tileWidth, 2*Tile.tileHeight, world);
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
		handler.getGc().blankSpace();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		//Tile.tiles[1].render(g, 10, 10);
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
