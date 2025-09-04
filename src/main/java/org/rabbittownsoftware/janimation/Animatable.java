package main.java.org.rabbittownsoftware.janimation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Represents an object that can be animated.
 *
 * <p>
 * Any engine or game object can implement this to plug into janimation.
 * The library will call {@link #drawFrame} to render animation frames.
 * </p>
 */
public interface Animatable
{
    /**
     * @return X position of this object in world or pixel space.
     */
    float getX();

    /**
     * @return Y position of this object in world or pixel space.
     */
    float getY();

    /**
     * Called by the animation system to draw the current frame.
     *
     * @param g      Graphics2D context to draw on.
     * @param frame  Current frame image.
     * @param x      X position in pixels.
     * @param y      Y position in pixels.
     * @param width  Width to render.
     * @param height Height to render.
     */
    void drawFrame(Graphics2D g, BufferedImage frame, int x, int y, int width, int height);
}
