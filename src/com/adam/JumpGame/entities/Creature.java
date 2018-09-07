package com.adam.JumpGame.entities;

import com.adam.JumpGame.Handler;
import com.adam.JumpGame.tiles.Tile;

public abstract class Creature extends Entity{

	public static final int defaultHP = 10, defaultSpeed = 5, defaultWidth = 32, defaultHeight = 32;
	protected int health, speed, xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		//calls constructor of Entity class and passes x, y input to it
		super(handler, x, y, width, height);
		health = defaultHP;
		speed = defaultSpeed;
		//xMove = 0;
		//yMove = 0;
	}
	
	public void move() {
		//xMove left(this is correct apparently???
		if(xMove > 0) {
			int tempX = (int)(x + xMove + bounds.width + bounds.x)/Tile.tileWidth;
			if(!collisionWBlock(tempX, (int)(y + bounds.y)/Tile.tileHeight) && !collisionWBlock(tempX, (int)(y + height + bounds.y)/Tile.tileHeight)) {
				x += xMove;
			}
		}
		//xMove right
		else if(xMove < 0) {
			int tempX = (int)(x + xMove + bounds.x)/Tile.tileWidth;
			if(!collisionWBlock(tempX, (int)(y + bounds.y)/Tile.tileHeight) && !collisionWBlock(tempX, (int)(y + height + bounds.y)/Tile.tileHeight)) {
				x += xMove;
			}
		}
		//yMove up
		if(yMove < 0) {
			int tempY = (int)(y + yMove + bounds.y)/Tile.tileHeight;
			if(!collisionWBlock((int)(x + bounds.x)/Tile.tileWidth, tempY) && !collisionWBlock((int)(x + bounds.width + bounds.x)/Tile.tileWidth, tempY)) {
				y += yMove;
			}
		}
		//yMove down
		else if(yMove > 0) {
			int tempY = (int)(y + yMove + bounds.y + bounds.height)/Tile.tileHeight;
			if(!collisionWBlock((int)(x + bounds.x)/Tile.tileWidth, tempY) && !collisionWBlock((int)(x + bounds.width + bounds.x)/Tile.tileWidth, tempY)) {
				y += yMove;
			}
		}
	}
	
	//takes in coordinate of block and returns if collision is true or false
	public boolean collisionWBlock(int x, int y) {
		return handler.getWorld().getTile(x, y).collision();
	}
	
	//getters and setters
	public int getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	public int getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
