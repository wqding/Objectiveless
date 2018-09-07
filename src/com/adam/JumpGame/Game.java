package com.adam.JumpGame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.adam.JumpGame.display.Display;
import com.adam.JumpGame.gfx.Assets;
import com.adam.JumpGame.input.KeyManager;
import com.adam.JumpGame.states.GameState;
import com.adam.JumpGame.states.MenuState;
import com.adam.JumpGame.states.State;
import com.adam.JumpGame.worlds.GameCamera;

public class Game implements Runnable{
	
	private Display display;
	public String title;
	public int width, height;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	
	private State gameState;
	private State menuState;
	
	private Handler handler;
	
	private KeyManager km;
	private GameCamera gc;
	
	//this constructor takes in these vars because the display obj is created in this class, which takes in the title, width, height vars of this class(not the inputed vars).
	//that is why this constructor sets the input t, w, h vars equal to the t, w, h vars created in this class
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		km = new KeyManager();
	}
	
	private void tick() {
		
		km.tick();
		
		if(State.getCurrentState() != null)
			State.getCurrentState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if(State.getCurrentState() != null)
			State.getCurrentState().render(g);
		
		bs.show();
		g.dispose();
	}
	
	//this method contains most of the code in this class, or most of the code that is run independently from the other classes(bc it's a thread)
	public void run() {

		//init
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(km);
		Assets.init();
		
		handler = new Handler(this);
		gc = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		//the currentState var in the state class is used to 
		State.setCurrentState(gameState);
		//end init
		
		int fps = 60;
		double timePerTick = 1000000000 / fps; //time in between every tick(update) in seconds to achieve 60 fps
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			//this line is basically the amount of time until calling the next tick and render methods
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				ticks++;
				render();
				delta--;
			}
			
			if(timer >= 1000000000) {
				//System.out.println("fps: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	public synchronized void start() {
		if(running)
			return;
		running = true;
		//means this class is going to be run on the thread
		thread = new Thread(this);
		//calls the run method in this class
		thread.start(); 
	}
	
	public synchronized void stop() {
		if(running == false)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public KeyManager getKm() {
		return km;
	}

	public void setKm(KeyManager km) {
		this.km = km;
	}

	public GameCamera getGc() {
		return gc;
	}

	public void setGc(GameCamera gc) {
		this.gc = gc;
	}

}
