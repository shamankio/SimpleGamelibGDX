package com.rust.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public class HouseView implements Screen {
    private BackgroundScene1 backgroundScene1;
    private BushScene1 bushScene1;
    private PostScene1 postScene1;
    private Slot slot;
    private Slots slots;
    private Key key1;
    private Letter letter;
    private Stage stage;
    private Group groupSlot, groupSlot1;
    private ItemSlot itemSlot;
    private boolean slotsVisible;


    public HouseView() {
        Gdx.app.log("My app", "car builder start");


        backgroundScene1 = new BackgroundScene1();

        itemSlot = ItemSlot.getInstance();


        bushScene1 = new BushScene1();
        bushScene1.setBounds(350, 100, 100, 100);
        bushScene1.addListener(new BushListener());

        postScene1 = new PostScene1();
        postScene1.setBounds(150, 335, 40, 40);
        postScene1.addListener(new PostListener());


        groupSlot1 = new Group();
        slotsVisible = false;
        slots = Slots.getInstance();
        groupSlot1.addActor(slots);
        groupSlot1.setVisible(slotsVisible);


        key1 = new Key();
        letter = new Letter();
        itemSlot.add(key1);
        itemSlot.add(letter);

        addSlotItems();

        groupSlot = new Group();
        slot = Slot.getInstance();
        slot.setBounds(50, 20, 85, 85);
        groupSlot.addListener(new SlotListener(groupSlot1, slotsVisible));
        groupSlot.addActor(slot);

        stage = new Stage(new StretchViewport(MyGdxGame.SCREEN_WIDTH, MyGdxGame.SCREEN_HIGHT));
        stage.getCamera().position.set(MyGdxGame.SCREEN_WIDTH / 2, MyGdxGame.SCREEN_HIGHT / 2 , 0);
        stage.addActor(backgroundScene1);
        stage.addActor(bushScene1);
        stage.addActor(postScene1);
        stage.addActor(groupSlot1);
        stage.addActor(groupSlot);

        Gdx.app.log("My app", "Create car" + itemSlot.toString());
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.app.log("My app", " show() car");


        groupSlot1.clear();
        slotsVisible = false;
        groupSlot1.addActor(slots);
        groupSlot1.setVisible(slotsVisible);

        addSlotItems();


        groupSlot.clear();
        groupSlot.addListener(new SlotListener(groupSlot1, slotsVisible));
        groupSlot.addActor(slot);

        if (slot.getItemBefore() != null)
            groupSlot.removeActor(slot.getItemBefore());
        Gdx.app.log("My app", "remove actor =" + slot.getItemBefore());
        if (slot.getItem() != null)
            groupSlot.addActor(slot.getItem());
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        if (ItemInSlots.getInstance().isItemClic())
            itemCliced();


    }


    public void addSlotItems() {
        ItemSlot[] slotButton = ItemInSlots.getInstance().createSlotButton();


        for (int i = 0; i < itemSlot.getAmount(); i++) {

            groupSlot1.removeActor(slotButton[i].getItem(i));
            groupSlot1.addActor(slotButton[i].getItem(i));
            Gdx.app.log("My app", "add actor" + i);
            Gdx.app.log("My app", "Create" + itemSlot.toString());
        }
    }


    public void itemCliced() {
        groupSlot.removeActor(slot.getItemBefore());
        Gdx.app.log("My app", "remove actor =" + slot.getItemBefore());

        groupSlot.addActor(slot.getItem());
        SlotListener.slotsVisible = false;
        groupSlot1.addAction(Actions.moveTo(0, -100, 1f));
        Gdx.app.log("My app", "slot actor =" + slot.getItem());
        Gdx.app.log("My app", "slot actor before=" + slot.getItemBefore());
        ItemInSlots.getInstance().setItemClic(false);


    }


    @Override
    public void resize(int width, int height) {
        Gdx.app.log("My app", "car resize()");
    }

    @Override
    public void pause() {
        Gdx.app.log("My app", "car pause()");
    }

    @Override
    public void resume() {
        Gdx.app.log("My app", "car resume()");
    }

    @Override
    public void hide() {
        Gdx.app.log("My app", "car hide()");
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        Gdx.app.log("My app", "car dispose()");
        stage.dispose();
    }

    class BushListener extends ClickListener {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            Gdx.app.log("My app", "Click bush");
            MyGdxGame.getInstance().showBush();

        }
    }

    class PostListener extends ClickListener {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            MyGdxGame.getInstance().showPost();
            Gdx.app.log("My app", "Click post");
        }
    }


}