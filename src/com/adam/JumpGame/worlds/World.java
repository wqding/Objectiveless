package com.adam.JumpGame.worlds;

import java.awt.Graphics;

import com.adam.JumpGame.Handler;
import com.adam.JumpGame.entities.Player;
import com.adam.JumpGame.tiles.Tile;

public class World {
	
	private int[][] world;
	private int width, height, spawnX, spawnY;
	private Handler handler;
	
	
	public World(Handler handler, String path){
		this.handler = handler;
		
		//String file = Util.loadFileAsString(path);
		//String[] mapData = file.split("\\s+");//saying that each space in the .txt file is a separator
		width = 25;
		height = 25;
		spawnX = 10;
		spawnY = 10;
		
		/*width = Util.stringToInt(mapData[2]);
		height = Util.stringToInt(mapData[3]);
		spawnX = Util.stringToInt(mapData[0]);
		spawnY = Util.stringToInt(mapData[1]);*/
		
		world = new int [width][height];		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(x == 0 || x == 24 || y == 0 || y == 24) {
					world[x][y] = 3;
				}
				else
					world[x][y] = (int)(Math.random()*2 + 1);
			}
		}
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, (int)(x*Tile.tileWidth - handler.getGc().getxOffset()), 
						(int)(y*Tile.tileHeight - handler.getGc().getyOffset()));
				
				/*world[x][y] returns an id
				getTile(world[x][y]).render(g, (int)(x*Tile.tileWidth - handler.getGc().getxOffset()), 
						(int)(y*Tile.tileHeight - handler.getGc().getyOffset()));*/
			}
		}
	}
	
	
	/*public Tile getTile(int id) {		
		if(Tile.tiles[id] == null)
			//change to tiles.dirt if errors
			return Tile.stone;
		return Tile.tiles[id];
	}*/


	public Tile getTile(int x, int y) {
		if(Tile.tiles[world[x][y]] == null) {
			return Tile.dirt;
		}
		return Tile.tiles[world[x][y]];
	}
	
	public int getWorld(int x, int y) {
		return world[x][y];
	}

	public void setWorld(int[][] world) {
		this.world = world;
	}
	
	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
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
