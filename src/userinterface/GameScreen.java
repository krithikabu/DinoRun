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

import objectgame.Cactus;
import objectgame.Clouds;
import objectgame.Land;
import objectgame.MainCharacter;
import objectgame.ObstaclesController;
import util.Sprite;

public class GameScreen extends JPanel implements Runnable, KeyListener{


	private Thread thread;
	public static final float GRAVITY = 0.25f;
	public static final float GROUND = 110;
	// public static final float GROUND = (float) (GameWindow.SCREEN_HEIGHT * (0.63));
	//private ImageIcon backgroundImage;
	BufferedImage backgroundImage;
	
	private MainCharacter dino;
	private Land land;
	private Clouds clouds;
//	private Cactus cactus;
	private ObstaclesController oc;
	private int score;
	private int HIscore = 0;
	
	private int gameMode = GAME_START_MODE;
	public static final int GAME_START_MODE = 0;
	public static final int GAME_PLAY_MODE = 1;
	public static final int GAME_END_MODE = 2;
	
	private BufferedImage dead;
	
	
	public GameScreen() {
		thread = new Thread(this);
		dino = new MainCharacter();
		land = new Land(this);
		dino.setX(50);
		dino.setY(62);
		clouds = new Clouds();
//		cactus = new Cactus();
		oc = new ObstaclesController(dino, this);
		dead = Sprite.getSpriteImage("data/gameover_text.png");
		
		/*
		try {
		backgroundImage = ImageIO.read(new File("data/background.png"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		*/
	}
	
	public void startGame() {
		thread.start();
	}
	
	public void run() {
		while(true) {
			try {
				move();
				repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	public void move() {
		switch(gameMode) {
		case GAME_PLAY_MODE:
			dino.move();
			land.move();
			clouds.move();
			oc.move();
			if (!dino.getAlive()) {
				gameMode = GAME_END_MODE;
			}
			break;
		}
		
//		cactus.move();
//		if (cactus.getBounds().intersects(dino.getBounds())) {
//			System.out.println("collision");
//		}
		
	}
	
	public void increaseScore(int score) {
		this.score += score;
		if (this.score >= HIscore) {
			HIscore = this.score;
		}
	}
	
	@Override
	public void paint (Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.decode("#f7f7f7"));
//		g.setColor(Color.decode("#f7f7f7"));
//		int w = this.getWidth();
//		int h = this.getHeight();
//		g.drawImage(backgroundImage, 0,  0, w, h, 0, 0, backgroundImage.getWidth(), backgroundImage.getHeight(), this);
//		g.drawLine(0, (int) GROUND, getWidth(), (int) GROUND);
		
		switch(gameMode) {
			case GAME_START_MODE:
				dino.draw(g);
				break;
			case GAME_PLAY_MODE:
				clouds.draw(g);
				land.draw(g);
				dino.draw(g);
				oc.draw(g);
				g.drawString("HI " + String.valueOf(HIscore), 450, 20);
				g.drawString(String.valueOf(score), 500, 20);
				break;
			case GAME_END_MODE:
				clouds.draw(g);
				land.draw(g);
				dino.draw(g);
				oc.draw(g);
				g.drawImage(dead,  200,  50,  null);
				break;
		}
//		clouds.draw(g);
//		land.draw(g);
//		dino.draw(g);
//		cactus.draw(g);
//		oc.draw(g);

	}
	
	private void resetGame() {
		dino.setAlive(true);
		dino.setX(50);
		dino.setY(62);
		oc.resetGame();
		score = 0;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("im just ken");
//		if((e.getKeyCode()== KeyEvent.VK_UP) || (e.getKeyCode()== KeyEvent.VK_SPACE))  {
//			dino.jump();
//		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("anywhere else id be a ten");
		if (KeyEvent.VK_SPACE  == e.getKeyCode()|| KeyEvent.VK_UP == e.getKeyCode()){
				if (gameMode == GAME_START_MODE) {
					gameMode = GAME_PLAY_MODE;
				} else if (gameMode == GAME_PLAY_MODE) {
					dino.jump();
				} else if (gameMode == GAME_END_MODE) {
					resetGame();
					gameMode = GAME_PLAY_MODE;
				}	
		} 
		if (KeyEvent.VK_RIGHT == e.getKeyCode()){
			if (gameMode == GAME_PLAY_MODE) {
				Land.landVelocity++;
				Clouds.cloudVelocity++;
				Cactus.cactusVelocity++;
			}
		}
		if (KeyEvent.VK_LEFT == e.getKeyCode()){
			if (gameMode == GAME_PLAY_MODE) {
				Land.landVelocity--;
				Clouds.cloudVelocity--;
				Cactus.cactusVelocity--;
			}
		}
	}

}