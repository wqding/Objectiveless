package com.adam.JumpGame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage grass, dirt, stone1, stone2, player, wood, sky;
	private static int blockHeight = 64;
	private static int blockWidth = 64;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet("/textures/sprite_sheet.png");
		
		grass = sheet.crop(4*blockWidth, 5*blockHeight, blockWidth, blockHeight);
		player=sheet.crop(0, 0, blockWidth, blockHeight);
		wood=sheet.crop(blockWidth*4, blockHeight*4, 64, 64);
		dirt=sheet.crop(blockWidth*2, blockHeight*4, blockWidth, blockHeight);
		stone1=sheet.crop(blockWidth, blockHeight*4, blockWidth, blockHeight);
		stone2=sheet.crop(0, blockHeight*4, blockWidth, blockHeight);
		sky=sheet.crop(0, blockHeight, blockWidth, blockHeight);
	}
	
}
