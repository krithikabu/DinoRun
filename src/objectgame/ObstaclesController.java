package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import userinterface.GameScreen;
import util.Sprite;

public class ObstaclesController {
	
	private List<Obstacle> obstacles;
	private Random r;
	private BufferedImage cactusImage1;
	private BufferedImage cactusImage2;
	private MainCharacter dino;
	private GameScreen gs;
	
	public ObstaclesController(MainCharacter dino, GameScreen gs) {
		this.dino = dino;
		this.gs = gs;
		obstacles = new ArrayList<Obstacle>();
		cactusImage1 = Sprite.getSpriteImage("data/cactus1.png");
		cactusImage2 = Sprite.getSpriteImage("data/cactus2.png");
		r = new Random();
		obstacles.add(getRandomCactus());
	}
	
	public void move() {
        for (Obstacle o : obstacles) {
            o.move();
            if (o.isOver() && !o.isScoreGot()) {
                gs.increaseScore(20);
                o.setIsScoreGot(true);
            }
            if (checkCollision(o)) {
                dino.setAlive(false);
            }
        }

        Obstacle firstCactus = obstacles.get(0);
        if (firstCactus.isOffScreen()) {
            obstacles.remove(firstCactus);
            obstacles.add(getRandomCactus());
        }
    }
	
	private boolean checkCollision(Obstacle o) {
        Rectangle[] dinoBounds = dino.getBounds();
        for (Rectangle dinoRect : dinoBounds) {
            if (dinoRect.intersects(o.getBounds())) {
                return true;
            }
        }
        return false;
    }
	
	public void draw(Graphics g) {
		for (Obstacle o: obstacles) {
			o.draw(g);
		}
	}
	
	public void resetGame() {
		obstacles.clear();
		obstacles.add(getRandomCactus());
	}
	
	private Cactus getRandomCactus() {
		Cactus cactus = new Cactus(dino);
		cactus.setX(600);
		if(r.nextBoolean()) {
			cactus.setImage(cactusImage1);
		} else {
			cactus.setImage(cactusImage2);
		}
		return cactus;
	}

}
