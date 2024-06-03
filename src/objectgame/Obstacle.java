package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Obstacle {

	public abstract Rectangle getBounds();
	public abstract void draw(Graphics g);
	public abstract void move();
	public abstract boolean isOffScreen();
	public abstract boolean isOver();
	public abstract boolean isScoreGot();
	public abstract void setIsScoreGot(boolean b);
}
