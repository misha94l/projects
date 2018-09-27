package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.controler.WarControler;

public class Warrior extends GameObject {

    private WarControler warControler;


    public Warrior(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        warControler = new WarControler(bounds);
}

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        warControler.handle();
    }

}
