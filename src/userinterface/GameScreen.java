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
import  javax.swing.JPanel;

import objectgame.MainCharacter;

public class GameScreen extends JPanel implements Runnable, KeyListener{
	
	
	private Thread thread;
	public static final float GRAVITY = 0.25f;
	public static final float GROUND = 300;
	
	private MainCharacter dino;
	
	
	public GameScreen() {
		thread = new Thread(this);
		dino = new MainCharacter();
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
		// Image image = ImageIO.read(new File("DinoIcon.png"));
		// g.drawImage(image, 0,0 ,null);
		g.setColor(Color.red);
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
