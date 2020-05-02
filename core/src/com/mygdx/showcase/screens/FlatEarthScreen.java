package com.mygdx.showcase.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.showcase.ShowcaseGame;

import static com.mygdx.showcase.ScreenViewConstants.GALLERY;

public class FlatEarthScreen implements Screen {
    ShowcaseGame parent;
    Stage stage;

    public FlatEarthScreen(ShowcaseGame parent){
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("flat-earth/flat-earth-ui.atlas"));
        TextureRegion background = atlas.findRegion("earth");
        Image image = new Image(background);
        image.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getWidth());
        image.setPosition(0,Gdx.graphics.getHeight()-image.getHeight());
        stage.addActor(image);

        Table layout = new Table();
        layout.setFillParent(true);
        stage.addActor(layout);

        Skin flatEarth = new Skin(Gdx.files.internal("flat-earth/flat-earth-ui.json"));

        Label title = new Label("Flat-Earth-UI", flatEarth);

        TextButton backButton = new TextButton("Back", flatEarth);
        backButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent e, Actor a){
                parent.changeScreen(GALLERY);
            }
        });

        Touchpad touchpad = new Touchpad(0, flatEarth);

        layout.add(title);
        layout.row().pad(10, 10,10, 10);
        layout.add(backButton).pad(0, 0, 0, 10);
        layout.add(touchpad);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
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

    }

    @Override
    public void dispose() {

    }
}
