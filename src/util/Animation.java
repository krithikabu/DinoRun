package util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.*;

public class Animation {
	private List<BufferedImage> frames;
	private int frameIdx = 0;
	private int timeChange;
	private long timeInitial;
	
	public Animation(int timeChange) {
		this.timeChange = timeChange;
		frames = new ArrayList<BufferedImage>();
		
	}
	
	public void move() {
		if(System.currentTimeMillis() - timeInitial > timeChange) {
			frameIdx++;
			if(frameIdx >= frames.size()) {
				frameIdx = 0;
			}
			timeInitial = System.currentTimeMillis();
		}
	}
	
	public void addFrame(BufferedImage frame) {
		frames.add(frame);
	}
	
	public BufferedImage getFrame() {
		if(frames.size() > 0) {
			return frames.get(frameIdx);
		}
		return null;
 	}
}
