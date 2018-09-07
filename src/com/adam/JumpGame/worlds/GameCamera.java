package com.adam.JumpGame.worlds;

import com.adam.JumpGame.Handler;
import com.adam.JumpGame.entities.Entity;
import com.adam.JumpGame.tiles.Tile;

public class GameCamera {

	//number of pixels from the original camera position which is (0, 0)
	private float xOffset, yOffset;
	private Handler handler;
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.xOffset=xOffset;
		this.yOffset=yOffset;
		this.handler=handler;
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	public void centerOnEntitiy(Entity e) {
		xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
	}

	public void blankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		}
		if(yOffset < 0) {
			yOffset = 0;
		}
		if(xOffset + handler.getWidth() > handler.getWorld().getWidth()*Tile.tileWidth) {
			xOffset = handler.getWorld().getWidth()*Tile.tileWidth - handler.getWidth();
		}
		if(yOffset + handler.getHeight() > handler.getWorld().getHeight()*Tile.tileHeight) {
			yOffset = handler.getWorld().getHeight()*Tile.tileHeight - handler.getHeight();
		}
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
}
