
package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.Sprite;

public class Cactus extends Obstacle {

	private BufferedImage image;
	private int posX;
	private int posY;
	private Rectangle rect;
	private MainCharacter dino;
	private boolean isScoreGot = false;

	public Cactus(MainCharacter dino) {
		this.dino = dino;
		image = Sprite.getSpriteImage("data/cactus1.png");
		posX = 200;
		posY = 65;
		rect = new Rectangle();
	}
	
	@Override
	public void move() {
		posX -= 3;
		rect.x = posX;
		rect.y = posY;
		rect.width = image.getWidth();
		rect.height = image.getHeight();
	}

	@Override
	public void draw (Graphics g) {
		g.drawImage(image, posX,  posY,  null);
	}
	
	@Override
	public Rectangle getBounds() {
		return rect;
	}
	
	public void setX(int x) {
		posX = x;
	}
	
	public void setY(int y) {
		posY = y;
	}
	
	public void setImage(BufferedImage i) {
		image = i;
	}
	
	@Override
	public boolean isOffScreen() {
		return (posX + image.getWidth()) < 0;
	}
	
	@Override
	public boolean isOver() {
		return dino.getX() > posX;
	}
	
	@Override
	public boolean isScoreGot() {
		return isScoreGot;
	}
	
	@Override
	public void setIsScoreGot(boolean b) {
		isScoreGot = b;
	}
	
}
