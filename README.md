# janimation

A lightweight **2D animation library for Java**, 
best for animating 2D sprites.

It provides:

- **AnimationController** – manages switching between animations.
- **Animator** – handles frame-based animation timing and rendering.
- **AnimationLoader** – loads and caches frames from resources.
- **Animatable** – an interface you can implement to connect your own game objects.

---

## Installation

### Option 1 – Manual JAR
Download the latest [release](https://github.com/Rabbit-Town-Software/janimation/releases) and add it to your project.

**Gradle**
```gradle
implementation files('libs/janimation-1.0.0.jar')
```

**Maven (local install)**
```bash
mvn install:install-file   -Dfile=janimation-1.0.0.jar   -DgroupId=org.rabbittownsoftware   -DartifactId=janimation   -Dversion=1.0.0   -Dpackaging=jar
```

### Option 2 – Source & Javadoc
Include `janimation-1.0.0-sources.jar` and `janimation-1.0.0-javadoc.jar` in your IDE for full inline documentation.

---

## Example

```java
// Define an Animatable entity
public class Player implements Animatable 
{
    private float x, y;

    @Override public float getX() { return x; }
    @Override public float getY() { return y; }

    @Override
    public void drawFrame(Graphics2D g, BufferedImage frame, int x, int y, int w, int h) 
    {
        g.drawImage(frame, x, y, w, h, null);
    }
}

// Load animations
Map<String, String[]> animationPaths = Map.of(
    "walk", new String[]{"sprites/walk1.png", "sprites/walk2.png"},
    "idle", new String[]{"sprites/idle1.png", "sprites/idle2.png"}
);

Map<String, BufferedImage[]> animations = AnimationLoader.loadNamedAnimations(animationPaths);

// Control animations
Player player = new Player();
AnimationController controller = new AnimationController(player, animations);
Animator animator = new Animator();

// During game loop
controller.play("walk");
animator.animate(controller.getCurrentAnimation(), true, player, g2d, 0, 0, 32);
```

---
