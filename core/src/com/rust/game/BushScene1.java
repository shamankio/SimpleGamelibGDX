package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class BushScene1 extends Actor {
    Texture texture;
    Sprite sprite;

    public BushScene1() {
        texture = new Texture("2.jpg");
        sprite = new Sprite(texture);
        sprite.setAlpha(0);
        sprite.setSize(100, 100);
        sprite.setPosition(350, 100);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, parentAlpha);

    }


}

