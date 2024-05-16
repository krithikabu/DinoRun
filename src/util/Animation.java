package util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    // List of frames in the animation
    private List<BufferedImage> frames;
    // Index of the current frame
    private int frameIdx = 0;
    // Time interval for frame change
    private int timeChange;
    // Initial time to track frame change timing
    private long timeInitial;

    public Animation(int timeChange) {
        this.timeChange = timeChange;
        frames = new ArrayList<BufferedImage>();
    }

    // Updates the animation frame based on the time interval
    public void move() {
        if(System.currentTimeMillis() - timeInitial > timeChange) {
            frameIdx++;
            if(frameIdx >= frames.size()) {
                frameIdx = 0;
            }
            timeInitial = System.currentTimeMillis();
        }
    }

    // Add a frame to the animation
    public void addFrame(BufferedImage frame) {
        frames.add(frame);
    }

    // Get the current frame of the animation


    public BufferedImage getFrame() {
        if(frames.size() > 0) {
            return frames.get(frameIdx);
        }
        return null;
    }
}