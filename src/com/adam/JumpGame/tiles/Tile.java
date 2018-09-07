package com.adam.JumpGame.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {

	
	//Static stuff
	public static Tile[] tiles = new Tile[10];//making a tile obj array
	public static Tile grass = new Grass(2);//creating a new Grass obj and setting its id to 0
	public static Tile sky = new Sky(0);
	public static Tile dirt = new Dirt(1);
	public static Tile stone = new Stone(3);
	
	//Actual tile class
	public static final int tileWidth = 64, tileHeight = 64;
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;//setting tiles at specific id's equal to the inputed textures of the subclasses.
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, tileWidth, tileHeight, null);
	}
		
	public boolean collision() {
		return false;
	}
	

	public int getID() {
		return id;
	}
}
