import java.awt.Color;
import java.awt.Graphics;
import java.util.*;


public class GamePanel extends AnimatedPanel{

	@Override
	public void updateAnimation() {
		// TODO Auto-generated method stub
		move();
		
	}

	private void move() {
		// TODO Auto-generated method stub
		
	}

	public Object easyMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object mediumMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object hardMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.print("Game Panel");
	}
	
	public void draw(Graphics g) {
        // TODO: Not Yet Implemented
        // consider drawing it a random color each time to illustrate some animation
        // using AnimatedPanel::getRandColor
        g.setColor(Color.BLACK);
        g.drawRect(Main.WIDTH / 6, Main.HEIGHT / 6, 500, 500);

    }

}
