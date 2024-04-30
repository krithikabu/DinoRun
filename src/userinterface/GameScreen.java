package userinterface;

import  javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable {
	
	private int i = 0;
	private Thread thread;
	
	public GameScreen() {
		thread = new Thread(this);
	}
	
	public void startGame() {
		thread.start();
	}
	
	public void run() {
		while(true) {
			System.out.println(i++);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
