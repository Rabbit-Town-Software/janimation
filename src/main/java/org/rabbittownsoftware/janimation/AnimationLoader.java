package main.java.org.rabbittownsoftware.janimation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Loads and caches animation frames from resources.
 */
@SuppressWarnings("unused")
public class AnimationLoader
{
    private static final Logger LOGGER = Logger.getLogger(AnimationLoader.class.getName());
    private static final ConcurrentHashMap<String, BufferedImage> IMAGE_CACHE = new ConcurrentHashMap<>();

    /**
     * Loads frames from resource paths.
     *
     * @param paths Array of resource paths.
     * @return Array of BufferedImages.
     */
    public static BufferedImage[] loadFrames(String[] paths)
    {
        return Stream.of(paths)
                .parallel()
                .map(AnimationLoader::loadImage)
                .filter(Objects::nonNull)
                .toArray(BufferedImage[]::new);
    }

    /**
     * Loads multiple named animations.
     *
     * @param animations Map of name → array of resource paths.
     * @return Map of name → frames.
     */
    public static Map<String, BufferedImage[]> loadNamedAnimations(Map<String, String[]> animations)
    {
        Map<String, BufferedImage[]> result = new HashMap<>();
        for (Map.Entry<String, String[]> entry : animations.entrySet())
        {
            result.put(entry.getKey(), loadFrames(entry.getValue()));
        }
        return result;
    }

    private static BufferedImage loadImage(String path)
    {
        if (IMAGE_CACHE.containsKey(path)) return IMAGE_CACHE.get(path);

        try (InputStream is = AnimationLoader.class.getClassLoader().getResourceAsStream(path))
        {
            if (is == null)
            {
                LOGGER.warning("Image not found: " + path);
                return null;
            }

            BufferedImage image = ImageIO.read(is);
            if (image != null)
            {
                IMAGE_CACHE.put(path, image);
                LOGGER.info("Loaded and cached: " + path);
            }
            return image;
        }
        catch (IOException e)
        {
            LOGGER.log(Level.SEVERE, "Failed to load image: " + path, e);
            return null;
        }
    }
}
