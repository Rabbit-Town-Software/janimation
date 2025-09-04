# JAnimation

A lightweight **2D animation library for Java**.

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

## License

JAnimation is licensed under the **GNU General Public License v3.0 (GPL-3.0)**.  
You are free to use, modify, and distribute the code, as long as any modified versions remain under the same license.

- ✔️ Commercial use allowed
- ✔️ Modifications allowed
- ✔️ Distribution allowed
- ❗ Derivative works must also be GPL-3.0 licensed

---

## Contact

Questions, bug reports, or feature requests?  
- Email: [support@rabbittownsoftware.com](mailto:support@rabbittownsoftware.com)
- Or open an [issue!](https://github.com/Rabbit-Town-Software/janimation/issues/new)

---


## Rabbit Town Software

<br/>

<p align="center">
  <img src="https://github.com/Rabbit-Town-Software/misa-engine/blob/eb3aa63bad02385d2af4b7b130d1bde70e2a2715/assets/rabbittownlogo.jpg?raw=true" alt="Rabbit Town Software Logo" width="180"/>
</p>

<p align="center">
  <strong>Rabbit Town Software</strong><br/>
  Open-source. No compromise.
</p>
