package Main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		new Window(250, 250, "TheThief", this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
