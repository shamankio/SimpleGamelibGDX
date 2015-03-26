package com.rust.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class BushView implements Screen {
    //    private final Skin skin;
//    private final Texture textureNoPress;
//    private final TextureRegion textureRegionNP;
//    private final Texture texturePress;
//    private final TextureRegion textureRegionP;

    private final ImageButton backButton;

    private BackgroundScene2 backgroundScene2;

    private Slot slot;
    private Slots slots;
    private ItemSlot[] slotButton;
    private Key key;
    private Letter letter;
    private Stage stage;
    private Group groupSlot, groupSlot1, groupWindowItem, groupButton;
    private ItemSlot itemSlot;
    private boolean slotsVisible;
    private GroundKey groundKey;
    private WindowItem windowItem;


    public BushView() {
        Gdx.app.log("My app", "Bush builder start");
        backgroundScene2 = new BackgroundScene2();
        itemSlot = ItemSlot.getInstance();

        groundKey = new GroundKey();
        groundKey.setBounds(207, 215, 80, 58);
        groundKey.addListener(new KeyGroundListener());

        windowItem = new WindowItem();
        key = new Key();
        groupWindowItem = new Group();
        key.setPosition(350, 300);
        key.setSize(300, 200);
        windowItem.setBounds(193, 154, 425, 241);
        groupWindowItem.setVisible(false);
        groupWindowItem.addListener(new WindowItemListener());
        groupWindowItem.addActor(windowItem);
        groupWindowItem.addActor(key);


//        textureNoPress = new Texture("strelka-2.png");
//        textureRegionNP = new TextureRegion(textureNoPress, 723, 404, 70, 70);
//
//
//        texturePress = new Texture("strelka-1.png");
//        textureRegionP = new TextureRegion(texturePress, 723, 404, 70, 70);
//        skin = new Skin();
//
//        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
//        style.imageUp = new TextureRegionDrawable(textureRegionNP);
//        style.imageDown = new TextureRegionDrawable(textureRegionP);
//        ImageButton backButton = new ImageButton(style);
//        backButton.setPosition(0, 0);
//        backButton.setBounds(723, 76, 70, 70);
//        backButton.addListener(new ButtonListener());
        backButton = new BackButton().getImageButton();
        backButton.addListener(new ButtonListener());


        groupSlot1 = new Group();
        slotsVisible = false;
        slots = Slots.getInstance();
        groupSlot1.addActor(slots);
        groupSlot1.setVisible(slotsVisible);


        addSlotItems();

        groupSlot = new Group();
        slot = Slot.getInstance();
        slot.setBounds(50, 20, 85, 85);
        groupSlot.addListener(new SlotListener(groupSlot1, slotsVisible));
        groupSlot.addActor(slot);


        stage = new Stage(new ScreenViewport());
        stage.addActor(backgroundScene2);
        stage.addActor(groupSlot1);
        stage.addActor(groupSlot);
        stage.addActor(groundKey);
        stage.addActor(groupWindowItem);
        stage.addActor(backButton);

        Gdx.app.log("My app", "Create bush" + itemSlot.toString());

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.app.log("My app", " show() bush");


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
        Gdx.app.log("My app", " resize() bush");
    }

    @Override
    public void pause() {
        Gdx.app.log("My app", " pause() bush");
    }

    @Override
    public void resume() {
        Gdx.app.log("My app", " resume() bush");
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
        Gdx.app.log("My app", " hide() bush");
    }

    @Override
    public void dispose() {
        Gdx.app.log("My app", " dispose() bush");
        stage.dispose();
    }


//    class SlotListener extends ClickListener {
//
//        @Override
//        public void clicked(InputEvent event, float x, float y) {
//            if (slotsVisible == false) {
//                slotsVisible = true;
//                groupSlot1.setVisible(slotsVisible);
//                Gdx.app.log("My app", "Click slotsVisible false ->" + slotsVisible);
//            } else {
//                if (slotsVisible == true) {
//                    slotsVisible = false;
//                    groupSlot1.setVisible(slotsVisible);
//                    Gdx.app.log("My app", "Click slotsVisible true ->" + slotsVisible);
//                }
//            }
//        }
//    }


    class KeyGroundListener extends ClickListener {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            groundKey.remove();


            groupWindowItem.setVisible(true);

            Gdx.app.log("My app", "Click ground key");
        }
    }

    class WindowItemListener extends ClickListener {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            groupWindowItem.setVisible(false);
            itemSlot.add(key);
            addSlotItems();
            groupSlot1.setVisible(true);
            Gdx.app.log("My app bush", "Click window item");
        }
    }

    public class ButtonListener extends ChangeListener {

        @Override
        public void changed(ChangeEvent event, Actor actor) {
            MyGdxGame.getInstance().showCar();
            System.out.println("Button Pressed");
        }
    }
}