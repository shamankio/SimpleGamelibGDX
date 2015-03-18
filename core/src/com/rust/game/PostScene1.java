package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class PostScene1 extends Actor {
    Texture texture;
    Sprite sprite;

    public PostScene1() {
        texture = new Texture("2.jpg");
        sprite = new Sprite(texture);
        sprite.setAlpha(0);
        sprite.setSize(40, 40);
        sprite.setPosition(150, 335);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, parentAlpha);

    }


}

