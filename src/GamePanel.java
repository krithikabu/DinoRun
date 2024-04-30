import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;


public class GamePanel extends AnimatedPanel{
	
	private BufferedImage image;

	@Override
	public void updateAnimation() {
		// TODO Auto-generated method stub
		move();
		
	}
	
	public GamePanel() {
		try {
			image = ImageIO.read(new File("DinosaurGame/src/DinoIcon.png"));
		} catch (IOException ex){
			System.out.println("File not found");
		}
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
	@Override
    public void paintComponent(Graphics g) {
        // Always call our superclass implementation first
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        
	}
	
	public void draw(Graphics g) {
        // TODO: Not Yet Implemented
        // consider drawing it a random color each time to illustrate some animation
        // using AnimatedPanel::getRandColor
        g.setColor(Color.BLACK);
        

    }

}
