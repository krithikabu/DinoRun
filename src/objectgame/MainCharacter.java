package objectgame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;


import javax.imageio.ImageIO;

import userinterface.GameScreen;
import util.Animation;
import util.Sprite;


public class MainCharacter {
	private float x = 0;
	private float y = 0;
	private float speedY = 0;
	private Animation dinoRun;
	
	public MainCharacter() {
		dinoRun = new Animation(200);
		dinoRun.addFrame(Sprite.getSpriteImage("data/main-character1.png"));
//		dinoRun.addFrame(Sprite.getSpriteImage("data/main-character1.png"));
//		dinoRun.addFrame(Sprite.getSpriteImage("data/main-character1.png"));
//		dinoRun.addFrame(Sprite.getSpriteImage("data/main-character2.png"));
//		dinoRun.addFrame(Sprite.getSpriteImage("data/main-character2.png"));
		dinoRun.addFrame(Sprite.getSpriteImage("data/main-character2.png"));
		
	}
	public float getSpeedY() {
		return speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	
	public void move() {
		dinoRun.move();
		if (y >= GameScreen.GROUND - dinoRun.getFrame().getHeight()) {
			speedY = 0;
			y = GameScreen.GROUND - dinoRun.getFrame().getHeight();
		} else {
			speedY += GameScreen.GRAVITY;
			y += speedY;
		}
	}
	
	public void jump() {
		speedY = -5;
		y += speedY;
	}
	
	public void draw(Graphics g) {
		BufferedImage bufferedImage;
		try {
			//bufferedImage = ImageIO.read(new File("DinoIcon.png"));
			//Image image = bufferedImage.getScaledInstance(125, 75, Image.SCALE_DEFAULT);
			//g.drawRect((int)x, (int)y, dinoRun.getFrame().getWidth(), dinoRun.getFrame().getHeight());
			//g.drawImage(image, (int)x, (int)y, null);
			//g.drawImage(character, (int)x, (int)y, null);
			g.drawImage(dinoRun.getFrame(), (int)x, (int)y, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
