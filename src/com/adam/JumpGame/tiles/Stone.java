package com.adam.JumpGame.tiles;

import com.adam.JumpGame.gfx.Assets;

public class Stone extends Tile{

	public Stone(int id) {
		super(Assets.stone1, id);
	}
	
	@Override
	public boolean collision() {
		return true;
	}
}
