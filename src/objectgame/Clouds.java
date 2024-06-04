package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import util.Sprite;

public class Clouds {

    private BufferedImage cloudImage;
    private List<Float> cloudPosX;
    private List<Float> cloudPosY;

    public Clouds() {
        cloudImage = Sprite.getSpriteImage("data/cloud.PNG");
        cloudPosX = new ArrayList<>();
        cloudPosY = new ArrayList<>();

        // Initial cloud positions
        cloudPosX.add(100f);
        cloudPosY.add(50f);

        cloudPosX.add(200f);
        cloudPosY.add(30f);

        cloudPosX.add(300f);
        cloudPosY.add(60f);

        cloudPosX.add(450f);
        cloudPosY.add(50f);

        cloudPosX.add(600f);
        cloudPosY.add(60f);
    }

    public void move() {
        // Move each cloud to the left
        for (int i = 0; i < cloudPosX.size(); i++) {
            cloudPosX.set(i, cloudPosX.get(i) - 1);
        }

        // Check if the first cloud is out of the screen
        if (cloudPosX.get(0) + cloudImage.getWidth() < 0) {
            // Move the first cloud to the end of the list
            float firstCloudY = cloudPosY.remove(0);
            cloudPosY.add(firstCloudY);

            float firstCloudX = cloudPosX.remove(0);
            cloudPosX.add(600f);
        }
    }

    public void draw(Graphics g) {
        // Draw each cloud at its position
        for (int i = 0; i < cloudPosX.size(); i++) {
            g.drawImage(cloudImage, cloudPosX.get(i).intValue(), cloudPosY.get(i).intValue(), null);
        }
    }
}