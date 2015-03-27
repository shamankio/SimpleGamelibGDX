package com.rust.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

public class MyGdxGame extends Game {
    public static final float SCREEN_WIDTH = 800;
    public static final float SCREEN_HIGHT = 480;
    private static MyGdxGame instance = new MyGdxGame();
    private HouseView houseView;
    private BushView bushView;
    private PostView postView;
    private AssetManager manager;


    private MyGdxGame() {
    }

    public static MyGdxGame getInstance() {
        return instance;
    }


    @Override
    public void create() {
        manager = new AssetManager();


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

    public AssetManager getAssetsManager(){
        return manager;
    }


}
