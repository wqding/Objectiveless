package com.adam.JumpGame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.adam.JumpGame.Handler;
import com.adam.JumpGame.gfx.Assets;
import com.adam.JumpGame.tiles.Dirt;
import com.adam.JumpGame.tiles.Tile;
import com.adam.JumpGame.worlds.World;

public class Player extends Creature{
	
	public World world;
	
	public Player(Handler handler, float x, float y, World world) {
		super(handler, x, y, Creature.defaultWidth, Creature.defaultHeight);
		this.world=world;
		
		//first two numbers are the numbers of pixels from top left corner of loaded image to top left corner of actual collision box, last two numbers
		//are collision box dimensions. My collision box is same size as img size so first two numbers are just 0.
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;
	}

	@Override
	public void tick() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKm().up)
			yMove = -speed;
		if(handler.getKm().down)
			yMove = speed;
		if(handler.getKm().left)
			xMove = -speed;
		if(handler.getKm().right)
			xMove = speed;
		
		move();
		handler.getGc().centerOnEntitiy(this);
		
		
		/*if(collision(this, world.getTile(1))) {
			System.out.println("collision detected!!");
		}*/
	}
	
	

	/*public Rectangle getBounds(int width, int height) {
		return new Rectangle((int)(x), (int)(y), width, height);
	}*/
	
	
	
	/*public boolean collision(Player player, Tile tile) {
		for(int y = 0; y < world.getHeight(); y++)
			for(int x = 0; x < world.getWidth(); x++) {
				if(world.getWorld(x,y) == 1) {
					if(player.getBounds(x, y).intersects(Dirt.getBounds(x, y, 64, 64)))
						return true;
				}
			}
		return false;
	}*/
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGc().getxOffset()), (int) (y - handler.getGc().getyOffset()), width, height, null);
		
		
		
		/*the x coord of top left corner of player + bounding box width (zero in this case) - the x displacement of camera 
		from orig position (0,0) = the position of collision box on the map
		g.fillRect((int) (x + bounds.x - handler.getGc().getxOffset()),
				(int) (y + bounds.y - handler.getGc().getyOffset()),bounds.width, bounds.height);*/
	}
	
}
