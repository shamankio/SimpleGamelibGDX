package com.rust.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class HouseView implements Screen {
    private BackgroundScene1 backgroundScene1;
    private BushScene1 bushScene1;
    private PostScene1 postScene1;
    private Slot slot;
    private Slots slots;
    private ItemSlot[] slotButton;
    private Key key, key1;
    private Letter letter;
    private Stage stage;
    private Group groupSlot, groupSlot1;
    private ItemSlot itemSlot;
    private boolean slotsVisible;


    public HouseView() {
        Gdx.app.log("My app", "builder start");

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


//        key1 = new Key();
//        letter = new Letter();
//        itemSlot.add(key1);
//              itemSlot.add(letter);


        Gdx.app.log("My app", "Create car" + itemSlot.toString());

        addSlotItems(createSlotButton());
        addSlotItemsListener(createSlotButton());


        groupSlot = new Group();
        slot = Slot.getInstance();
        slot.setBounds(50, 20, 85, 85);
//        slot.addListener(new SlotListener());
        groupSlot.addListener(new SlotListener());
        groupSlot.addActor(slot);


        stage = new Stage(new ScreenViewport());
        stage.addActor(backgroundScene1);
        stage.addActor(bushScene1);
        stage.addActor(postScene1);
        stage.addActor(groupSlot1);
        stage.addActor(groupSlot);

        Gdx.app.log("My app", "Create" + itemSlot.toString());


    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.app.log("My app", " show() car");


        groupSlot1.clear();
        slotsVisible = false;
        groupSlot1.addActor(slots);
        groupSlot1.setVisible(slotsVisible);

        addSlotItems(createSlotButton());
        addSlotItemsListener(createSlotButton());

        groupSlot.clear();
        groupSlot.addListener(new SlotListener());
        groupSlot.addActor(slot);

        if (slot.getItemBefore() != null)
            groupSlot.removeActor(slot.getItemBefore());
        Gdx.app.log("My app", "remove actor =" + slot.getItemBefore());
        if (slot.getItem() != null)
            groupSlot.addActor(slot.getItem());


    }

    @Override
    public void render(float delta) {
        //    Gdx.app.log("My app", "car render()");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    public ItemSlot[] createSlotButton() {
        slotButton = new ItemSlot[itemSlot.getAmount()];
        for (int i = 0; i < itemSlot.getAmount(); i++) {
            slotButton[i] = itemSlot;
            if (i == 0) {
                slotButton[i].setPosition(200, 20);
                Gdx.app.log("My app", "x pos" + i + "=" + (slotButton[i].getX()));
                slotButton[i].getItem(i).setPosition(200, 20);
                Gdx.app.log("My app", "x bon" + i + "=" + (slotButton[i].getX()));
            } else {
                slotButton[i].setPosition(slotButton[i - 1].getX() + 85, 20);
                Gdx.app.log("My app", "x pos" + i + "=" + (slotButton[i - 1].getX()));
                slotButton[i].getItem(i).setPosition(slotButton[i].getX(), 20);
                Gdx.app.log("My app", "x bon" + i + "=" + (slotButton[i].getX()));
            }


        }
        return slotButton;
    }

    public void addSlotItems(ItemSlot[] slotButton) {


        for (int i = 0; i < itemSlot.getAmount(); i++) {
            float x = slotButton[i].getItem(i).getX();
            float y = slotButton[i].getItem(i).getY();
            slotButton[i].getItem(i).setBounds(x, y, 85, 85);
            groupSlot1.removeActor(slotButton[i].getItem(i));
            groupSlot1.addActor(slotButton[i].getItem(i));
            Gdx.app.log("My app", "add actor" + i);
            Gdx.app.log("My app", "Create" + itemSlot.toString());
        }
    }

    public void addSlotItemsListener(ItemSlot[] slotButton) {


        for (int i = 0; i < itemSlot.getAmount(); i++) {

            slotButton[i].getItem(i).addListener(new SlotItemListener(i));
            Gdx.app.log("My app", "add listener" + i);

        }
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
            MyGdxGame.getInstance().showBush();
            Gdx.app.log("My app", "Click bush");
        }
    }

    class PostListener extends ClickListener {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            MyGdxGame.getInstance().showPost();
            Gdx.app.log("My app", "Click post");
        }
    }

    class SlotListener extends ClickListener {

        @Override
        public void clicked(InputEvent event, float x, float y) {
            if (slotsVisible == false) {
                slotsVisible = true;
                groupSlot1.setVisible(slotsVisible);
                Gdx.app.log("My app1", "Click slotsVisible false ->" + slotsVisible);
            } else {
                if (slotsVisible == true) {
                    slotsVisible = false;
                    groupSlot1.setVisible(slotsVisible);
                    Gdx.app.log("My app1", "Click slotsVisible true ->" + slotsVisible);
                }
            }
        }
    }

    class SlotItemListener extends ClickListener {
        int position;

        public SlotItemListener(int position) {
            this.position = position;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public void clicked(InputEvent event, float x, float y) {

            Gdx.app.log("My app", "Click slot" + getPosition());
            slot.setViewActor(true);
            slot.setItem(itemSlot.getItem(getPosition()));
            slot.getItem().setPosition(50, 20);
            slot.getItem().setBounds(50, 20, 85, 85);
            groupSlot.removeActor(slot.getItemBefore());
            Gdx.app.log("My app", "remove actor =" + slot.getItemBefore());

            groupSlot.addActor(slot.getItem());
            slotsVisible = false;
            groupSlot1.setVisible(slotsVisible);
            Gdx.app.log("My app", "slot actor =" + slot.getItem());
            Gdx.app.log("My app", "slot actor before=" + slot.getItemBefore());


        }

    }
}