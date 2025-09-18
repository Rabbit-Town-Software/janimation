# JAnimation

A lightweight **2D animation library for Java**.

It provides:

- **AnimationController** – manages switching between animations.
- **Animator** – handles frame-based animation timing and rendering.
- **AnimationLoader** – loads and caches frames from resources.
- **Animatable** – an interface you can implement to connect your own game objects.

---

## Installation

### Manual JAR (Recommended for most users)

Download the latest **janimation-1.0.0.jar**, **janimation-1.0.0-sources.jar**, and **janimation-1.0.0-javadoc.jar** and place it into your project’s `libs/` folder.  

**Gradle**  
```gradle
dependencies {
    implementation files('libs/janimation-1.0.0.jar')
    compileOnly files('libs/janimation/janimation-1.0.0-sources.jar')  
    compileOnly files('libs/janimation/janimation-1.0.0-javadoc.jar')
}
```

**Maven (local install)**  
Since JAnimation isn’t on Maven Central, you can install it into your local Maven repository:  

```bash
mvn install:install-file     
-Dfile=janimation-1.0.0.jar     
-DgroupId=org.rabbittownsoftware     
-DartifactId=janimation     
-Dversion=1.0.0     
-Dpackaging=jar
```

Then include it in your `pom.xml`:  
```xml
<dependency>
  <groupId>org.rabbittownsoftware</groupId>
  <artifactId>janimation</artifactId>
  <version>1.0.0</version>
</dependency>
```

---
### Attach Sources and Javadoc (Optional)

To get **inline documentation and source browsing** inside your IDE, download the extra JARs from the release:  

- `janimation-1.0.0-sources.jar`  
- `janimation-1.0.0-javadoc.jar`  

Attach them manually in your IDE:  

**IntelliJ IDEA**  
1. Right-click the dependency in the Project view.  
2. Select **Library Properties**.  
3. Attach the `-sources.jar` and `-javadoc.jar`.  

**Eclipse**  
1. Right-click the library under *Referenced Libraries*.  
2. Select **Properties → Javadoc Location**.  
3. Point to the `-javadoc.jar`.  
4. Do the same for **Source Attachment** with the `-sources.jar`.  

---
### Option 3 – Build From Source (For contributors)

Clone the repo and build with Gradle:  

```bash
git clone https://github.com/Rabbit-Town-Software/janimation.git
cd janimation
./gradlew build
```

This produces JARs under `build/libs/`, which you can then include in your project manually.  

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
