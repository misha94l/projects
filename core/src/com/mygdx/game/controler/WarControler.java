package com.mygdx.game.controler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.view.GameScreen;


public class WarControler {
    private Polygon warBounds;
    private float rotationSpeed = 60f;

    public WarControler(Polygon warBounds) {
        this.warBounds = warBounds;
    }

    float speed, velocity = 3f, speedMax = 5f;
    public void handle() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            speed += velocity * GameScreen.deltaCff;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            speed -= velocity * GameScreen.deltaCff;
        }
        else
            downSpeed();

        speed = sliceSpeed();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            warBounds.rotate(rotationSpeed * GameScreen.deltaCff);
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            warBounds.rotate(- rotationSpeed * GameScreen.deltaCff);


        warBounds.setPosition(warBounds.getX() + MathUtils.cosDeg(warBounds.getRotation() + 90 ) * speed * GameScreen.deltaCff,
                                warBounds.getY() + MathUtils.sinDeg(warBounds.getRotation() + 90) * speed * GameScreen.deltaCff);
    }

    private float sliceSpeed() {
        if (speed > speedMax)
            return speedMax;
        else if (speed < - speedMax)
            return -speedMax;

        return speed;
    }

    private void downSpeed() {
        if (speed > velocity)
            speed -= velocity * GameScreen.deltaCff;
        else if (speed < - velocity)
            speed += velocity * GameScreen.deltaCff;
        else
            speed = 0f;
    }
}
