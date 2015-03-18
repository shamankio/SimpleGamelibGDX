package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class GroundKey extends Actor {
    private Texture texture;
    private Sprite sprite;
    private TextureRegion region;

    public GroundKey() {
        texture = new Texture("df.png");
        TextureRegion region = new TextureRegion(texture, 207, 207, 80, 58);
        sprite = new Sprite(region);
        sprite.setSize(80, 58);
        sprite.setPosition(207, 215);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, parentAlpha);

    }

}

