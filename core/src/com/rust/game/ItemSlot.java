package com.rust.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class ItemSlot extends Actor {

    private static ItemSlot instance = new ItemSlot();
    private Array<Actor> item = new Array<Actor>();


    //   private Array slotListeners = new Array();
    private int amount = 0;

    private ItemSlot() {
    }

    public static ItemSlot getInstance() {
        return instance;
    }


    public boolean isEmpty() {
        return item == null || amount <= 0;
    }

    public boolean add(Actor item) {
        this.item.add(item);
        this.amount += 1;

        return true;

    }

    public boolean take(int amount) {
        //       if (this.amount >= amount) {
//            this.item.get(amount);
        this.item.removeIndex(amount - 1);
        this.amount -= 1;
//        }
//            if (this.amount == 0) {
//                item = null;
//            }

        return true;

    }

    public Actor getItem(int index) {
        return item.get(index);
    }


    public int getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "Slot[" + item + ":" + amount + "]";
    }


}