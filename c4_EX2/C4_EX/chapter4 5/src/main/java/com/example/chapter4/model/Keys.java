package com.example.chapter4.model;

import javafx.scene.input.KeyCode;

import java.util.HashMap;

//Imports are omitted
 public class Keys {
 private HashMap<KeyCode,Boolean> keys;
 public Keys() {
         keys = new HashMap<>();
         }
 public void add(KeyCode key) {
         keys.put(key, true);
         }
 public void remove(KeyCode key) {
         keys.put(key, false);
         }
         public boolean isPressed(KeyCode key) {
         return keys.getOrDefault(key,false);
         }
}