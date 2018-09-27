package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.model.Backer;
import com.mygdx.game.model.Warrior;

public class GameScreen implements Screen {

    private Texture warTexture;
    private SpriteBatch batch;
    private Warrior war;
    private OrthographicCamera camera;
   // private Texture backer;
    //private Backer back;

    public static float deltaCff;

    @Override
    public void show() {
        batch = new SpriteBatch();
        warTexture = new Texture(Gdx.files.internal("test.png"));
        warTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        //backer = new Texture(Gdx.files.internal("backer.png"));
       // backer.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
       // back = new Backer(backer, 0, 0, 10f, 10f);
        war = new Warrior(warTexture, 0,0, 1.0f,1.0f * 1.26f);

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
           // back.draw(batch);
            war.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height/width;
        camera = new OrthographicCamera(20f, 20f * aspectRatio);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        warTexture.dispose();
        batch.dispose();
    }
}
