package com.rust.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BackButton {


    private final ImageButton imageButton;
    private Texture texturePress, textureNoPress;
    private TextureRegion textureRegionP, textureRegionNP;


    public BackButton() {
        textureNoPress = new Texture("strelka-2.png");
        textureRegionNP = new TextureRegion(textureNoPress, 723, 404, 70, 70);


        texturePress = new Texture("strelka-1.png");
        textureRegionP = new TextureRegion(texturePress, 723, 404, 70, 70);


        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.imageUp = new TextureRegionDrawable(textureRegionNP);
        style.imageDown = new TextureRegionDrawable(textureRegionP);
        imageButton = new ImageButton(style);

        imageButton.setBounds(723, 76, 70, 70);
    }

    public ImageButton getImageButton() {
        return imageButton;
    }


}