package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BackgroundScene1 extends Actor {
    private Texture bgtexture;
    private Sprite bgsprite;

    public BackgroundScene1() {
        bgtexture = new Texture("1.jpg");
        bgsprite = new Sprite(bgtexture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        bgsprite.draw(batch, parentAlpha);
    }

}