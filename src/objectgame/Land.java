package objectgame;

import java.awt.Graphics;
import static userinterface.GameScreen.GROUND;
import java.awt.image.BufferedImage;

import userinterface.GameScreen;
import util.Sprite;

public class Land {
	
	private BufferedImage imageLand;
	
	
	public Land () {
		imageLand = Sprite.getSpriteImage("data/background.png");
	}
	
	public void draw(Graphics g) {
		g.drawImage(imageLand, (int) GameScreen.GROUND,50, null);
		
	}
}
