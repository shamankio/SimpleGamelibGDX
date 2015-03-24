package com.rust.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ItemInSlots {
    private ItemSlot[] slotButton;
    private ItemSlot itemSlot;
    private Slot slot;
    private boolean itemClic = false;
    private static ItemInSlots instance = new ItemInSlots(ItemSlot.getInstance());


    private ItemInSlots(ItemSlot itemSlot) {

        this.itemSlot = itemSlot;
    }
    public static ItemInSlots getInstance() {
        return instance;
    }

    public boolean isItemClic() {
        return itemClic;
    }

    public void setItemClic(boolean itemClic) {
        this.itemClic = itemClic;
    }

    public ItemSlot[] createSlotButton() {
        slotButton = new ItemSlot[itemSlot.getAmount()];
       for (int i = 0; i < itemSlot.getAmount(); i++) {
            slotButton[i] = itemSlot;
            if (i == 0) {
                slotButton[i].setPosition(200, -100);
                Gdx.app.log("My app", "x pos" + i + "=" + (slotButton[i].getX()));
                slotButton[i].getItem(i).setPosition(200, -100);
                Gdx.app.log("My app", "x bon" + i + "=" + (slotButton[i].getX()));
            } else {
                slotButton[i].setPosition(slotButton[i - 1].getX() + 85, -100);
                Gdx.app.log("My app", "x pos" + i + "=" + (slotButton[i - 1].getX()));
                slotButton[i].getItem(i).setPosition(slotButton[i].getX(), -100);
                Gdx.app.log("My app", "x bon" + i + "=" + (slotButton[i].getX()));
            }
           float x = slotButton[i].getItem(i).getX();
           float y = slotButton[i].getItem(i).getY();
           slotButton[i].getItem(i).setBounds(x, y, 85, 85);
           if (slotButton[i].getItem(i).getListeners().size < 1)
               slotButton[i].getItem(i).addListener(new SlotItemListener(i));


        }
        return slotButton;
    }

class SlotItemListener extends ClickListener {
    int  position;

    public SlotItemListener(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        slot = Slot.getInstance();

        Gdx.app.log("My app ItemInSlot ", "Click slot" + getPosition());
        slot.setViewActor(true);
        slot.setItem(itemSlot.getItem(getPosition()));
        slot.getItem().setPosition(50, 20);
        slot.getItem().setBounds(50, 20, 85, 85);
        itemClic = true;

    }

}
}
