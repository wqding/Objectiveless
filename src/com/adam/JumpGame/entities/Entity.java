package com.adam.JumpGame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.adam.JumpGame.Handler;

public abstract class Entity {
	
	protected float x, y;
	protected int width, height;
	protected Handler handler;
	public Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		/*first two numbers are the numbers of pixels from top left corner of loaded image to top left corner of actual collision box, last two numbers
		are collision box dimensions. My collisionb box is same size as img size so first two numbers are just 0.
		try removing the 2 0's later (to see if they are actually needed bc our collision box is not smaller than img size)*/
		bounds = new Rectangle(0, 0, width, height);
	}
	

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
