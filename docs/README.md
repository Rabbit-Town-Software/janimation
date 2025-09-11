# JAnimation Documentation

Welcome to the **JAnimation** user documentation! 

This library provides simple tools for frame-based animation in Java.

---
## Overview

JAnimation is built around four main components:

1. **Animatable** – The interface your game objects implement to support animation.  
2. **AnimationController** – Manages switching between animations.  
3. **AnimationLoader** – Loads and caches animation frames from resources.  
4. **Animator** – Handles timing and rendering of animation frames.

---
## Table of Contents

- [Installation](Java%20Libraries/JAnimation/Documentation%20(Users)/1.%20Installation.md)  
- [Animatable](2.%20Animatable.md)  
- [AnimationLoader](3.%20AnimationLoader.md)  
- [AnimationController](4.%20AnimationController.md)  
- [Animator](5.%20Animator.md)  
- [Basic Demo](Java%20Libraries/JAnimation/Documentation%20(Users)/6.%20Basic%20Demo.md)

---
## Getting Started

1. Implement `Animatable` in your game object.  
2. Use `AnimationLoader` to load animation frames from resources.  
3. Create an `AnimationController` to manage which animation is active.  
4. Pass the current frames to `Animator` to render them with proper timing.
