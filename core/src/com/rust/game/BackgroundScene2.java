package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BackgroundScene2 extends Actor {
    private Texture bgtexture;
    private Sprite bgsprite;

    public BackgroundScene2() {

        if(MyGdxGame.getInstance().getAssetsManager().isLoaded("6.jpg",Texture.class))
            System.out.println("6 loaded");
        bgtexture = MyGdxGame.getInstance().getAssetsManager().get("6.jpg",Texture.class);
        bgsprite = new Sprite(bgtexture);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        bgsprite.draw(batch, parentAlpha);
    }

}