package com.example.chapter4.controller;

import com.example.chapter4.model.Characters;
import com.example.chapter4.view.Platform;


 public class GameLoop implements Runnable {
 private Platform platform;
 private int frameRate;
 private float interval;
 private boolean running;
 public GameLoop(Platform platform) {
         this.platform = platform;
         frameRate = 10;
         interval = 1000.0f / frameRate;
         running = true;
         }
 private void update(Characters character) {
     if (platform.getKeys().isPressed(character.getLeftKey())) {
          character.setScaleX(-1);
          character.moveLeft();
         platform.getCharacter().trace();
          }
      if (platform.getKeys().isPressed(character.getRightKey())) {
          character.setScaleX(1);
          character.moveRight();
          platform.getCharacter().trace();
          }
      if (!platform.getKeys().isPressed(character.getLeftKey()) && !platform.
             getKeys().isPressed(character.getRightKey()) ) {
          character.stop();
          }
     if (platform.getKeys().isPressed(character.getLeftKey()) || platform.
             getKeys().isPressed(character.getRightKey())) {
          character.getImageView().tick();
          }
     if (platform.getKeys().isPressed(character.getUpKey())) {
          character.jump();
          }
 }

@Override
 public void run() {
         while (running) {
             float time = System.currentTimeMillis();
             update(platform.getCharacter());
             update(platform.getCharacter2());
             time = System.currentTimeMillis() - time;
             if (time < interval) {
                 try {
                     Thread.sleep((long) (interval - time));
                     } catch (InterruptedException e) {
                     e.printStackTrace();
                     }
                } else {
                 try {
                     Thread.sleep((long) (interval - (interval % time)));
                     } catch (InterruptedException e) {
                     e.printStackTrace();
                     }
                 }
             }
         }
 }