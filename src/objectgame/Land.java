package objectgame;

import java.awt.Graphics;
import static userinterface.GameScreen.GROUND;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import userinterface.GameScreen;
import util.Sprite;

public class Land {
    
    // List to hold the land images
    private List<ImageLand> listImage;
    // BufferedImage objects to hold the different land images
    private BufferedImage imageLand1;
    private BufferedImage imageLand2;
    private BufferedImage imageLand3;
    // Random object to generate random numbers
    private Random random;
    
    // Constructor
    public Land(GameScreen game) {
        random = new Random(); // Initialize Random object
        // Load land images
        imageLand1 = Sprite.getSpriteImage("data/land1.png");
        imageLand2 = Sprite.getSpriteImage("data/land2.png");
        imageLand3 = Sprite.getSpriteImage("data/land3.png");
        listImage = new ArrayList<ImageLand>(); // Initialize list of land images
        
        // Calculate the number of land tiles needed to cover the screen width
        int numberOfLandTitle = 600 / imageLand1.getWidth() + 2;
        System.out.println(numberOfLandTitle); // Print the number of land tiles
        
        // Initialize land tiles
        for (int i = 0; i < numberOfLandTitle; i++) {
            ImageLand imageLand = new ImageLand();
            imageLand.posX = (int) (i * imageLand1.getWidth()); // Set initial position of land tile
            imageLand.image = getImageLand(); // Get random land image
            listImage.add(imageLand); // Add land tile to the list
        }
    }
    
    // Method to move the land tiles
    public void move() {
        for (ImageLand imageLand : listImage) {
            imageLand.posX -= 3; // Move each land tile to the left
        }
        ImageLand firstElement = listImage.get(0); // Get the first land tile
        if (firstElement.posX + imageLand1.getWidth() < 0) {
            // If the first land tile is out of the screen, reposition it to the end of the last tile
            firstElement.posX = listImage.get(listImage.size() - 1).posX + imageLand1.getWidth();
            listImage.add(listImage.get(0)); // Add the first tile to the end of the list
            listImage.remove(0); // Remove the first tile from the beginning of the list
        }
    }
    
    // Method to draw the land tiles
    public void draw(Graphics g) {
        for (ImageLand imageLand : listImage) {
            // Draw each land tile at its current position
            g.drawImage(imageLand.image, imageLand.posX, (int) GameScreen.GROUND - 20, null);
        }
    }
    
    // Method to get a random land image
    private BufferedImage getImageLand() {
        int i = random.nextInt(3); // Generate a random number between 0 and 2
        switch(i) {
            case 0: return imageLand1; // Return the first land image
            case 1: return imageLand2; // Return the second land image
            default: return imageLand3; // Return the third land image
        }
    }
    
    // Inner class to represent a land tile
    private class ImageLand {
        int posX; // X position of the land tile
        BufferedImage image; // Image of the land tile
    }
}