package com.adam.JumpGame.tiles;

import java.awt.Rectangle;

import com.adam.JumpGame.gfx.Assets;

public class Dirt extends Tile{

	public Dirt(int id) {
		super(Assets.dirt, id);
	}
	
	/*public static Rectangle getBounds(int x, int y, int width, int height) {
		return new Rectangle((int)x, (int)y, width, height);
	}*/
}

