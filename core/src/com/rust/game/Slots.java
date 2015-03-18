package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Slots extends Actor {
    private static Slots instance = new Slots();
    private Texture texture;
    private TextureRegion textureRegion;
    private Sprite sprite;

    private Slots() {
        texture = new Texture("slotu.png");
        textureRegion = new TextureRegion(texture, 112, 382, 600, 90);
//        slot1 = new TextureRegion(texture,112)
        sprite = new Sprite(textureRegion);
        sprite.setSize(600, 90);
        sprite.setPosition(200, 20);
    }

    public static Slots getInstance() {
        return instance;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, parentAlpha);
    }


}

