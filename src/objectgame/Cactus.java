package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.Sprite;

public class Cactus {

	private BufferedImage image;
	private int posX;
	private int posY;
	private Rectangle rect;

	public Cactus() {
		image = Sprite.getSpriteImage("data/cactus1.png");
		posX = 200;
		posY = 65;
	}

	public void move() {
		posX -= 3;
	}

	public void draw (Graphics g) {
		g.drawImage(image, posX,  posY,  null);
	}
}