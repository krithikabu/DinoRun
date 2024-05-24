package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import util.Sprite;

public class Clouds {
	
	private BufferedImage cloudImage;
	
	public Clouds () {
		cloudImage = Sprite.getSpriteImage("data/cloud.PNG");
	}
	
	public void draw(Graphics g) {
		g.drawImage(cloudImage,  100,  100,  null);
		
	}
	
}
