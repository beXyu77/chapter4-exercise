package com.example.chapter4;

import com.example.chapter4.controller.DrawingLoop;
import com.example.chapter4.controller.GameLoop;
import com.example.chapter4.view.Platform;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Imports are omitted
 public class Launcher extends Application {
 public static void main(String[] args) { launch(args); }
 @Override
 public void start(Stage stage) {
         Platform platform = new Platform();
         GameLoop gameLoop = new GameLoop(platform);
         DrawingLoop drawingLoop = new DrawingLoop(platform);
         Scene scene = new Scene(platform, platform.WIDTH, platform.HEIGHT);
         scene.setOnKeyPressed(event-> platform.getKeys().add(event.getCode()));
         scene.setOnKeyReleased(event -> platform.getKeys().remove(event.getCode()));
         stage.setTitle("platformer");
         stage.setScene(scene);
         stage.show();
         (new Thread(gameLoop)).start();
         (new Thread(drawingLoop)).start();
         }
 }