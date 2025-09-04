package main.java.org.rabbittownsoftware.janimation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;

/**
 * Handles frame-based animation timing and rendering for {@link Animatable} objects.
 */
@SuppressWarnings("unused")
public class Animator
{
    private static final Logger LOGGER = Logger.getLogger(Animator.class.getName());

    private int currentFrame = 0;
    private long lastFrameTime = 0;
    private long frameDuration = 200; // ms per frame

    /**
     * Animates an {@link Animatable} by rendering its current frame.
     *
     * @param animationFrames Frames for the current animation.
     * @param shouldLoop Whether to loop or stop at the last frame.
     * @param animatable The object being animated.
     * @param graphics2D Graphics2D context.
     * @param offsetX X offset (world or camera).
     * @param offsetY Y offset (world or camera).
     * @param size Size (in pixels) to render frame at.
     */
    public void animate(
            BufferedImage[] animationFrames,
            boolean shouldLoop,
            Animatable animatable,
            Graphics2D graphics2D,
            float offsetX,
            float offsetY,
            int size
    )
    {
        if (animationFrames == null || animationFrames.length == 0)
        {
            LOGGER.warning("Animation skipped: no frames provided.");
            return;
        }

        long currentTime = System.nanoTime();
        if (shouldUpdateFrame(currentTime))
        {
            updateCurrentFrame(animationFrames, shouldLoop);
            lastFrameTime = currentTime;
        }

        BufferedImage frame = animationFrames[currentFrame];
        int px = (int) (animatable.getX() + offsetX);
        int py = (int) (animatable.getY() + offsetY);

        animatable.drawFrame(graphics2D, frame, px, py, size, size);
    }

    private boolean shouldUpdateFrame(long currentTime)
    {
        long elapsed = (currentTime - lastFrameTime) / 1_000_000; // ms
        return elapsed > frameDuration;
    }

    private void updateCurrentFrame(BufferedImage[] frames, boolean shouldLoop)
    {
        currentFrame++;
        if (currentFrame >= frames.length)
        {
            currentFrame = shouldLoop ? 0 : frames.length - 1;
        }
    }

    /**
     * Sets frame duration in milliseconds.
     */
    public void setFrameDuration(long duration)
    {
        if (duration <= 0)
        {
            LOGGER.warning("Invalid duration. Resetting to default (200ms).");
            this.frameDuration = 200;
        }
        else
        {
            this.frameDuration = duration;
            LOGGER.info("Frame duration set to: " + duration + "ms");
        }
    }
}
