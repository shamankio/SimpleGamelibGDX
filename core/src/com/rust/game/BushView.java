package com.rust.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class BushView implements Screen {
    private final Skin skin;
    private final Texture textureNoPress;
    private final TextureRegion textureRegionNP;
    private final Texture texturePress;
    private final TextureRegion textureRegionP;

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


        textureNoPress = new Texture("strelka-2.png");
        textureRegionNP = new TextureRegion(textureNoPress, 723, 404, 70, 70);


        texturePress = new Texture("strelka-1.png");
        textureRegionP = new TextureRegion(texturePress, 723, 404, 70, 70);
        skin = new Skin();

        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.imageUp = new TextureRegionDrawable(textureRegionNP);
        style.imageDown = new TextureRegionDrawable(textureRegionP);
        ImageButton imageButton = new ImageButton(style);
        imageButton.setPosition(0, 0);
        imageButton.setBounds(723, 76, 70, 70);
        imageButton.addListener(new ButtonListener());


        groupSlot1 = new Group();
        slotsVisible = false;
        slots = Slots.getInstance();
        groupSlot1.addActor(slots);
        groupSlot1.setVisible(slotsVisible);


        addSlotItems(createSlotButton());
        addSlotItemsListener(createSlotButton());

        groupSlot = new Group();
        slot = Slot.getInstance();
        slot.setBounds(50, 20, 85, 85);

        groupSlot.addListener(new SlotListener());
        groupSlot.addActor(slot);


        stage = new Stage(new ScreenViewport());
        stage.addActor(backgroundScene2);
        stage.addActor(groupSlot1);
        stage.addActor(groupSlot);
        stage.addActor(groundKey);
        stage.addActor(groupWindowItem);
        stage.addActor(imageButton);

        Gdx.app.log("My app", "Create" + itemSlot.toString());

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.app.log("My app", " show() bush");


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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);

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

            slotButton[i].getItem(i).addListener(new SlotItemListenerBushView(i));
            Gdx.app.log("My app", "add listener" + i);

        }
    }


    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }


    class SlotListener extends ClickListener {

        @Override
        public void clicked(InputEvent event, float x, float y) {
            if (slotsVisible == false) {
                slotsVisible = true;
                groupSlot1.setVisible(slotsVisible);
                Gdx.app.log("My app", "Click slotsVisible false ->" + slotsVisible);
            } else {
                if (slotsVisible == true) {
                    slotsVisible = false;
                    groupSlot1.setVisible(slotsVisible);
                    Gdx.app.log("My app", "Click slotsVisible true ->" + slotsVisible);
                }
            }
        }
    }

    class SlotItemListenerBushView extends ClickListener {
        int position;

        public SlotItemListenerBushView(int position) {
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
            addSlotItems(createSlotButton());
            Gdx.app.log("My app", "Click window item");
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