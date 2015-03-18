package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BackgroundScene3 extends Actor {
    private Texture bgtexture;
    private Sprite bgsprite;

    public BackgroundScene3() {
        bgtexture = new Texture("2.jpg");
        bgsprite = new Sprite(bgtexture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        bgsprite.draw(batch, parentAlpha);
    }

}