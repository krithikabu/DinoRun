package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import util.Sprite;

public class Clouds {

    private BufferedImage cloudImage;
    private List<Integer> cloudPosX;
    private List<Integer> cloudPosY;

    public Clouds() {
        cloudImage = Sprite.getSpriteImage("data/cloud.PNG");
        cloudPosX = new ArrayList<>();
        cloudPosY = new ArrayList<>();

        // Initial cloud positions
        cloudPosX.add(100);
        cloudPosY.add(50);

        cloudPosX.add(200);
        cloudPosY.add(30);

        cloudPosX.add(300);
        cloudPosY.add(60);

        cloudPosX.add(450);
        cloudPosY.add(50);

        cloudPosX.add(600);
        cloudPosY.add(60);
    }

    public void move() {
        // Move each cloud to the left
        for (int i = 0; i < cloudPosX.size(); i++) {
            cloudPosX.set(i, cloudPosX.get(i) - 1);
        }

        // Check if the first cloud is out of the screen
        if (cloudPosX.get(0) + cloudImage.getWidth() < 0) {
            // Move the first cloud to the end of the list
            int firstCloudY = cloudPosY.remove(0);
            cloudPosY.add(firstCloudY);

            int firstCloudX = cloudPosX.remove(0);
            cloudPosX.add(600);
        }
    }

    public void draw(Graphics g) {
        // Draw each cloud at its position
        for (int i = 0; i < cloudPosX.size(); i++) {
            g.drawImage(cloudImage, cloudPosX.get(i), cloudPosY.get(i), null);
        }
    }
}