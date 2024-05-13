package util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprite {
	public static BufferedImage getSpriteImage(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return img;
	}
}
