package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class PostOpenLetter extends Actor {
    private Texture texture;
    private Sprite sprite;
    private TextureRegion region;

    public PostOpenLetter() {

        texture = new Texture("3.png");
        sprite = new Sprite(texture);
        sprite.setSize(800, 480);
        sprite.setPosition(0, 0);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, parentAlpha);

    }

}

