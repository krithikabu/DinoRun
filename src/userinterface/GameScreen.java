package userinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import  javax.swing.JPanel;

import objectgame.MainCharacter;

public class GameScreen extends JPanel implements Runnable, KeyListener{
	
	
	private Thread thread;
	public static final float GRAVITY = 0.25f;
	public static final float GROUND = (float) (GameWindow.SCREEN_HEIGHT * (0.63));
	//private ImageIcon backgroundImage;
	BufferedImage backgroundImage;
	
	private MainCharacter dino;
	
	
	public GameScreen() {
		thread = new Thread(this);
		dino = new MainCharacter();
		// backgroundImage = new ImageIcon("data/background.png");
		try {
			backgroundImage = ImageIO.read(new File("data/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startGame() {
		thread.start();
	}
	
	public void run() {
		while(true) {
			try {
				dino.move();
				repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public void paint (Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.MAGENTA);
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawImage(backgroundImage, 0,  0, w, h, 0, 0, backgroundImage.getWidth(), backgroundImage.getHeight(), this);
		g.drawLine(0, (int) GROUND, getWidth(), (int) GROUND);	
		dino.draw(g);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("im just ken");
		if((e.getKeyCode()== KeyEvent.VK_UP) || (e.getKeyCode()== KeyEvent.VK_SPACE))  {
			dino.jump();
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("anywhere else id be a ten");
		
	}

}
