package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import util.Sprite;

public class Land {
	
	private BufferedImage imageLand;
	
	public Land () {
		imageLand = Sprite.getSpriteImage("data/background.png");
	}
	
	public void draw(Graphics g) {
		
	}
}
