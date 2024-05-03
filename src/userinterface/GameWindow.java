package userinterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private GameScreen gameScreen;
	
	public GameWindow() {
		super("Java T-Rex game");
		setSize(750, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScreen = new GameScreen();
		add(gameScreen);
		addKeyListener(gameScreen);
	}
	
	public static void main(String args[]) {
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
		gw.startGame();
	}
	
	public void startGame() {
		gameScreen.startGame();
	}
	
	/*
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("painting", 0, 0);
		try {
			// Image image = ImageIO.read(new File("DinoIcon.png"));
			// g.drawImage(image, 0,0 ,null);
			BufferedImage bufferedImage = ImageIO.read(new File("DinoIcon.png"));
			Image image = bufferedImage.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
			g.drawImage(image, 150, 150, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
}
