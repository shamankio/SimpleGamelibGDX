package com.rust.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Slot extends Actor {
    private static Slot instance = new Slot();
    Texture texture;
    TextureRegion textureRegion;
    Sprite sprite;
    Actor item, itemBefore;
    Boolean viewActor = false;

    private Slot() {
        texture = new Texture("slotu.png");
        textureRegion = new TextureRegion(texture, 6, 382, 90, 90);
        sprite = new Sprite(textureRegion);
        sprite.setSize(90, 90);
        sprite.setPosition(50, 20);
        setBounds(50, 20, 85, 85);

    }

    public static Slot getInstance() {
        return instance;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, parentAlpha);
    }

    public Actor getItemBefore() {
        return itemBefore;
    }

    public Actor getItem() {
        return this.item;
    }

    public void setItem(Actor item) {
        Gdx.app.log("My app", "item name =" + item.getClass());

        if (item.getClass().toString().equals("class com.rust.game.Key")) {
            this.itemBefore = this.item;
            this.item = new Key();
        }
        if (item.getClass().toString().equals("class com.rust.game.Letter")) {
            this.itemBefore = this.item;
            this.item = new Letter();
        }
//        this.item.setPosition(50, 20);
//        this.item.setBounds(50, 20, 85, 85);

    }


    public void setViewActor(Boolean viewActor) {
        this.viewActor = viewActor;
    }
}

