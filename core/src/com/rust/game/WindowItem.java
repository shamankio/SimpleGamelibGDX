package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class WindowItem extends Actor {
    Texture texture;

    public WindowItem() {
        texture = new Texture("OKNO.png");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, 193, 154, 500, 300);
    }

}

