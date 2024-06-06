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

    private List<Integer> listPosX; // List to hold the X positions of the land tiles
    private List<BufferedImage> listImages; // List to hold the images of the land tiles
    private BufferedImage imageLand1;
    private BufferedImage imageLand2;
    private BufferedImage imageLand3;
    public static int landVelocity = 3;
    private Random random;

    public Land(GameScreen game) {
        random = new Random();
        imageLand1 = Sprite.getSpriteImage("data/land1.png");
        imageLand2 = Sprite.getSpriteImage("data/land2.png");
        imageLand3 = Sprite.getSpriteImage("data/land3.png");
        listPosX = new ArrayList<>();
        listImages = new ArrayList<>();

        int numberOfLandTitle = 600 / imageLand1.getWidth() + 2;
        System.out.println(numberOfLandTitle);

        for (int i = 0; i < numberOfLandTitle; i++) {
            listPosX.add(i * imageLand1.getWidth()); // Set initial position of land tile
            listImages.add(getRandomLandImage()); // Get random land image
        }
    }

    public void move() {
        for (int i = 0; i < listPosX.size(); i++) {
            listPosX.set(i, listPosX.get(i) - landVelocity); // Move each land tile to the left
        }

        if (listPosX.get(0) + imageLand1.getWidth() < 0) {
            int lastIndex = listPosX.size() - 1;
            listPosX.set(0, listPosX.get(lastIndex) + imageLand1.getWidth());
            listPosX.add(listPosX.remove(0)); // Move the first position to the end
            listImages.add(listImages.remove(0)); // Move the first image to the end
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < listPosX.size(); i++) {
            g.drawImage(listImages.get(i), listPosX.get(i), (int) (GROUND - 20), null);
        }
    }

    private BufferedImage getRandomLandImage() {
        int i = random.nextInt(3);
        switch (i) {
            case 0:
                return imageLand1;
            case 1:
                return imageLand2;
            default:
                return imageLand3;
        }
    }
}