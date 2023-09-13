package com.example.chapter4.controller;

import com.example.chapter4.model.Characters;
import com.example.chapter4.view.Platform;

//Imports are omitted
 public class DrawingLoop implements Runnable {
 private Platform platform;
 private int frameRate;
 private float interval;
 private boolean running;
 public DrawingLoop(Platform platform) {
        this.platform = platform;
         frameRate = 30;
         interval = 1000.0f / frameRate; // 1000 ms = 1 second
         running = true;
         }
 private void checkDrawCollisions(Characters character) {
         character.checkReachGameWall();
         character.checkReachHighest();
         character.checkReachFloor();
         }
 private void paint(Characters character) {
         character.repaint();
         }
 @Override
 public void run() {
         while (running) {
             float time = System.currentTimeMillis();
             checkDrawCollisions(platform.getCharacter());
             checkDrawCollisions(platform.getCharacter2());
             paint(platform.getCharacter());
             paint(platform.getCharacter2());
             time = System.currentTimeMillis() - time;
             if (time < interval) {
                 try {
                     Thread.sleep((long) (interval - time));
                     } catch (InterruptedException e) {
                     }
                 } else {
                 try {
                     Thread.sleep((long) (interval - (interval % time)));
                     } catch (InterruptedException e) {
                     }
                 }
             }
         }
 }