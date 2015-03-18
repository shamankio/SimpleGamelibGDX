package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Button extends Actor {


    public static boolean presButton = false;
    private final Skin skin;
    private Texture texturePress, textureNoPress;
    private TextureRegion textureRegionP, textureRegionNP;
    private Sprite sprite, sprite1;
    private Actor item, itemBefore;

    public Button() {

        textureNoPress = new Texture("strelka-2.png");
        textureRegionNP = new TextureRegion(textureNoPress, 723, 404, 70, 70);
        sprite = new Sprite(textureRegionNP);
        sprite.setSize(70, 70);

        texturePress = new Texture("strelka-1.png");
        textureRegionP = new TextureRegion(texturePress, 723, 404, 70, 70);
        sprite1 = new Sprite(textureRegionNP);
        sprite1.setSize(70, 70);
        skin = new Skin();

        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle(skin.get(com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle.class));
        style.imageUp = new TextureRegionDrawable(textureRegionNP);
        style.imageDown = new TextureRegionDrawable(textureRegionP);
        ImageButton iconButton = new ImageButton(style);


    }

    public void draw(Batch batch, float parentAlpha) {

        if (presButton)

            sprite.draw(batch, parentAlpha);

        else

            sprite1.draw(batch, parentAlpha);
    }


}