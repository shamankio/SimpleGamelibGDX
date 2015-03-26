package com.rust.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyGdxGame extends Game {
    private static MyGdxGame instance = new MyGdxGame();
    private HouseView houseView;
    private BushView bushView;
    private PostView postView;


    private MyGdxGame() {
    }

    public static MyGdxGame getInstance() {
        return instance;
    }


    @Override
    public void create() {


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
