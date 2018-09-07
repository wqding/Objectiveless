package com.adam.JumpGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	/*idea for collision, basically store the x and y coord(multiplying the world[x]and[y] by 64 and storing them in two arrays, if the corners of the 
		player equals any of them then you can move, now i gotta figure out how to not move*/
	
	/*k so to not move i could use two if statements, the out side one is if the corner coord is equal to the coord of the block, the second is if the 
	 * the key entered is still in the direction of the block then the xMove or yMove will equal to 0, but this would mean that i would have to store 
	 */
	
	/*jk imma use the rectangle method, watch the youtube vid pal*/
	
	private boolean [] keys;
	public boolean up, down, left, right;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		//System.out.println("test");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
