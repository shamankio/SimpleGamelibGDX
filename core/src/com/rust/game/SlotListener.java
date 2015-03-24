package com.rust.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Sasha on 24.03.2015.
 */

class SlotListener extends ClickListener {
    private  Group groupSlot1;
   public static boolean slotsVisible;


    public SlotListener(Group groupSlot1, boolean slotVisible){
        this.groupSlot1 = groupSlot1;
        this.slotsVisible = slotVisible;
    }


    @Override
    public void clicked(InputEvent event, float x, float y) {
        if (slotsVisible == false) {
            slotsVisible = true;
            groupSlot1.setVisible(slotsVisible);
            groupSlot1.addAction(Actions.moveTo(0, 120, 0.5f));
            Gdx.app.log("My Slot Listener", "Click slotsVisible false ->" + slotsVisible);

        } else {
            if (slotsVisible == true) {
                slotsVisible = false;
                groupSlot1.addAction(Actions.moveTo(0,-100,0.5f));
                if(groupSlot1.getY()==-20)
                    groupSlot1.setVisible(slotsVisible);
                Gdx.app.log("My Slot Listener", "Click slotsVisible true ->" + slotsVisible);

            }
        }
    }
}