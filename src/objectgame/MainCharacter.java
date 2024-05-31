
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
    private Rectangle rect;

    public MainCharacter() {
        // Initialize the animation with a frame change interval of 200 milliseconds
        dinoRun = new Animation(200);
        // Add frames to the animation
        dinoRun.addFrame(Sprite.getSpriteImage("data/main-character1.png"));
        dinoRun.addFrame(Sprite.getSpriteImage("data/main-character2.png"));
        rect = new Rectangle();
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
        
    }

    // Make the character jump
    public void jump() {
        speedY = -5;
        y += speedY;
    }

    // Draw the character on the screen
    public void draw(Graphics g) {
        try {
            // Draw the current frame of the animation
        	g.setColor(Color.PINK);
    		g.drawRect((int) x, (int) y, 39, 43);
            g.drawImage(dinoRun.getFrame(), (int)x, (int)y, null);
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        }
    }
}
