package Main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{
	
	public Game() {
		new Window(625, 625, "TheThief", this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String[] args) {
		new Game();
	}
}
