package com.rust.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
    private static MyGdxGame instance = new MyGdxGame();
    private SpriteBatch batch;
    private HouseView houseView;
    private BushView bushView;
    private PostView postView;
    private ItemSlot itemSlot;
    private Slots slots;
    private Slot slot;

    private MyGdxGame() {
    }

    public static MyGdxGame getInstance() {
        return instance;
    }


    @Override
    public void create() {
        itemSlot = ItemSlot.getInstance();
        slots = Slots.getInstance();
        slot = Slot.getInstance();


        bushView = new BushView();
        Gdx.app.log("My app", "Load BushView");

        postView = new PostView();
        Gdx.app.log("My app", "Load PostView");
        houseView = new HouseView();
        Gdx.app.log("My app", "Load HouseView");

        setScreen(houseView);
    }

    public void showBush() {
        this.setScreen(bushView);
    }

    public void showCar() {
        this.setScreen(houseView);
    }

    public void showPost() {
        this.setScreen(postView);
    }

    @Override
    public void render() {
        super.render();
    }

}
