package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import util.Sprite;

public class Clouds {
	
	private BufferedImage cloudImage;
	private List<Cloud> clouds;
	
	public Clouds () {
		cloudImage = Sprite.getSpriteImage("data/cloud.PNG");
		clouds = new ArrayList<Cloud>();
		
		Cloud cloud1 = new Cloud();
		cloud1.posX = 100;
		cloud1.posY = 50;
		clouds.add(cloud1);
		
		cloud1 = new Cloud();
		cloud1.posX = 20;
		cloud1.posY = 30;
		clouds.add(cloud1);
		
		cloud1 = new Cloud();
		cloud1.posX = 350;
		cloud1.posY = 80;
		clouds.add(cloud1);
		
		cloud1 = new Cloud();
		cloud1.posX = 450;
		cloud1.posY = 60;
		clouds.add(cloud1);
		
		cloud1 = new Cloud();
		cloud1.posX = 550;
		cloud1.posY = 50;
		clouds.add(cloud1);
	}
	
	public void move() {
		for(Cloud cloud: clouds) {
			cloud.posX --;
		}
	}
	
	public void draw(Graphics g) {
		for (Cloud cloud : clouds) {
			g.drawImage(cloudImage, (int) cloud.posX, (int) cloud.posY, null);
		}
		
	}
	
	
	private class Cloud {
		float posX;
		float posY;
	}
	
}
