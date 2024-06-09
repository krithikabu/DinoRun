
package objectgame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;

import userinterface.GameScreen;
import util.Animation;
import util.Sprite;

public class MainCharacter {
    // Position coordinates of the main character
    private float x = 0;
    private float y = 0;
    
    // Vertical speed of the main character
    private float speedY = 0;
    // Animation for the running dino
    private Animation dinoRun;
    private Rectangle rectHead;
    private Rectangle rectBody;
    private Rectangle rectLegs;
    private boolean isAlive = true;

    public MainCharacter() {
        // Initialize the animation with a frame change interval of 200 milliseconds
        dinoRun = new Animation(200);
        // Add frames to the animation
        dinoRun.addFrame(Sprite.getSpriteImage("data/main-character1.png"));
        dinoRun.addFrame(Sprite.getSpriteImage("data/main-character2.png"));
        rectHead = new Rectangle();
        rectBody = new Rectangle();
        rectLegs = new Rectangle();
    }

    // Getter for speedY
    public float getSpeedY() {
        return speedY;
    }

    // Setter for speedY
    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    // Getter for y
    public float getY() {
        return y;
    }

    // Setting y
    public void setY(float y) {
        this.y = y;
        
    }

    // Getter for x
    public float getX() {
        return x;
    }

    // Setter for x
    public void setX(float x) {
        this.x = x;
    }
    
    // setter for isAlive
    public void setAlive(Boolean alive) {
    	isAlive = alive;
    }
    
    // getter for isAlive
    public boolean getAlive() {
    	return isAlive;
    }

    // Move the character and update its animation frame
    public void move() {
        dinoRun.move();
        // Check if the character is on the ground
        if (y >= GameScreen.GROUND - dinoRun.getFrame().getHeight()) {
            speedY = 0;
            y = GameScreen.GROUND - dinoRun.getFrame().getHeight();
        } else {
            // Apply gravity to the character
            speedY += GameScreen.GRAVITY;
            y += speedY;
        }
//        rectHead.x = (int) x + (dinoRun.getFrame().getWidth() / 2);
//        rectHead.y = (int) y;
//        rectHead.width = dinoRun.getFrame().getWidth() / 2;
//        rectHead.height = dinoRun.getFrame().getHeight() / 3;
//        
//        rectBody.x = (int) x;
//        rectBody.y = (int) y + (dinoRun.getFrame().getHeight() / 3);
//        rectBody.width = dinoRun.getFrame().getWidth();
//        rectBody.height = dinoRun.getFrame().getHeight() / 3;
//        
//        rectLegs.x = (int) x + (dinoRun.getFrame().getWidth() / 3);
//        rectLegs.y = (int) y + (dinoRun.getFrame().getHeight() / 3);
//        rectLegs.width = dinoRun.getFrame().getWidth() / 3;
//        rectLegs.height = dinoRun.getFrame().getHeight() / 3;
        rectHead.setBounds((int)x + dinoRun.getFrame().getHeight() / 4, (int)y, dinoRun.getFrame().getWidth() / 2, dinoRun.getFrame().getHeight() / 3);
        rectBody.setBounds((int)x, (int)y + dinoRun.getFrame().getHeight() / 3, dinoRun.getFrame().getWidth(), dinoRun.getFrame().getHeight() / 3);
        
        //rectLegs.setBounds((int)x, (int)y + 2 * dinoRun.getFrame().getHeight() / 3, dinoRun.getFrame().getWidth(), dinoRun.getFrame().getHeight() / 3);
        int legSquareSize = dinoRun.getFrame().getHeight() / 3;
        rectLegs.setBounds((int)x + (dinoRun.getFrame().getWidth() - legSquareSize) / 2 - 5, (int)y + 2 * dinoRun.getFrame().getHeight() / 3, legSquareSize, legSquareSize);
    
    }
    
    public Rectangle[] getBounds() {
        return new Rectangle[] { rectHead, rectBody, rectLegs };
    }

//    // Make the character jump
//    public void jump() {
//        speedY = -6;
//        y += speedY;
//    }
    
    public void jump() {
        if (y == GameScreen.GROUND - dinoRun.getFrame().getHeight()) {
            speedY = -6;
            y += speedY;
        }
    }

    // Draw the character on the screen
    public void draw(Graphics g) {
        try {
            // Draw the current frame of the animation
        	g.drawImage(dinoRun.getFrame(), (int)x, (int)y, null);
            g.setColor(Color.PINK);
            g.drawRect(rectHead.x + 10, rectHead.y, rectHead.width, rectHead.height);
            g.drawRect(rectBody.x, rectBody.y, rectLegs.width * 2 + 5, rectBody.height);
            //g.setColor(Color.GREEN);
            g.drawRect(rectLegs.x, rectLegs.y, rectLegs.width, rectLegs.height);
            
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        }
    }
}