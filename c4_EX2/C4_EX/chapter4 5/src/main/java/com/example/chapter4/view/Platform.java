package com.example.chapter4.view;

import com.example.chapter4.Launcher;
import com.example.chapter4.model.Characters;
import com.example.chapter4.model.Keys;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class Platform extends Pane {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    public final static int GROUND = 300;
    private Image platformImg;
    private Characters character;
    private Characters character2;
    private Keys keys;



    public Platform() {
        keys = new Keys();
        platformImg = new Image(Objects.requireNonNull(Launcher.class.getResourceAsStream("assets/Background.png")));
        ImageView backgroundImg = new ImageView(platformImg);
        backgroundImg.setFitHeight(HEIGHT);
        backgroundImg.setFitWidth(WIDTH);


        character = new Characters(30, 30, 0, 0, KeyCode.A, KeyCode.D, KeyCode.W,0);

        character2 = new Characters(40, 30, 0, 0, KeyCode.LEFT, KeyCode.RIGHT, KeyCode.UP,1);
        getChildren().addAll(backgroundImg, character, character2); // Add character2 to the scene



    }

    public Characters getCharacter() {
        return character;
    }
    public Characters getCharacter2() {
        return character2;
    }

    public Keys getKeys() {
        return keys;
    }


}
