package main.java.org.rabbittownsoftware.janimation;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Manages switching between different animations for an {@link Animatable}.
 *
 * <p>
 * Stores named animation frame arrays and tracks which one is currently playing.
 * </p>
 */
@SuppressWarnings("unused")
public class AnimationController
{

    private final Map<String, BufferedImage[]> animations;
    private String currentAnimationName = null;

    /**
     * Creates a new AnimationController.
     *
     * @param animatable The object being animated.
     * @param animations Map of animation names to frame arrays.
     */
    public AnimationController(Animatable animatable, Map<String, BufferedImage[]> animations)
    {
        this.animations = animations;
    }

    /**
     * Plays a specific animation by name.
     * <p>
     * If the animation is already active, does nothing.
     *
     * @param name Name of the animation to play.
     */
    public void play(String name)
    {
        if (!animations.containsKey(name))
        {
            System.err.println("[AnimationController] Missing animation: " + name);
            return;
        }

        if (!name.equals(currentAnimationName))
        {
            currentAnimationName = name;
        }
    }

    /**
     * Gets the currently active animation frames.
     *
     * @return Array of frames for the current animation, or null if none is playing.
     */
    public BufferedImage[] getCurrentAnimation()
    {
        if (currentAnimationName == null) return null;
        return animations.get(currentAnimationName);
    }

    /**
     * @param name Name of animation to check.
     * @return True if the animation is currently playing.
     */
    public boolean isPlaying(String name)
    {
        return name.equals(currentAnimationName);
    }
}
