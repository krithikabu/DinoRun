package objectgame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;


import javax.imageio.ImageIO;

import userinterface.GameScreen;


public class MainCharacter {
	private float x = 0;
	private float y = 0;
	private float speedY = 0;
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
		if (y >= GameScreen.GROUND - 55) {
			speedY = 0;
			y = GameScreen.GROUND - 55;
		} else {
			speedY += GameScreen.GRAVITY;
			y += speedY;
		}
	}
	
	public void jump() {
		speedY = -4;
		y += speedY;
	}
	
	public void draw(Graphics g) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File("DinoIcon.png"));
			Image image = bufferedImage.getScaledInstance(125, 75, Image.SCALE_DEFAULT);
			g.drawImage(image, (int)x, (int)y, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
