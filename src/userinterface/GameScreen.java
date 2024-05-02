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

public class GameScreen extends JPanel implements Runnable, KeyListener{
	
	private float x = 0;
	private float y = 0;
	private float speedY = 0;
	private Thread thread;
	public static final float GRAVITY = 0.1f;
	
	public GameScreen() {
		thread = new Thread(this);
	}
	
	public void startGame() {
		thread.start();
	}
	
	public void run() {
		while(true) {
			try {
				speedY += GRAVITY;
				y += speedY;
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
		/*
		 * g.setColor(Color.white); 
		 * g.fillRect(0, 0, getWidth(), getHeight());
		 * g.setColor(Color.black); 
		 * g.drawRect((int) x, (int) y, 100, 100);
		 */
		try {
			// Image image = ImageIO.read(new File("DinoIcon.png"));
			// g.drawImage(image, 0,0 ,null);
			BufferedImage bufferedImage = ImageIO.read(new File("DinoIcon.png"));
			Image image = bufferedImage.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
			
			g.drawImage(image, (int)x, (int)y, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Pressed");
		speedY = -4;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Released");
		
	}

}
