package com.mygdx.showcase.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.showcase.ShowcaseGame;

import static com.mygdx.showcase.ScreenViewConstants.*;

public class GalleryScreen implements Screen {
    ShowcaseGame parent;

    private Stage stage;

    public GalleryScreen(ShowcaseGame parent){
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
        System.out.println("in gallery");
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Skin glassy = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label showcaseTitle = new Label("Skin Showcase", glassy, "big");
        showcaseTitle.setColor(Color.BLACK);
        Label titleLabel = new Label("Glassy UI", glassy);
        titleLabel.setColor(Color.BLACK);

        TextButton flatEarthButton = new TextButton("Flat-Earth-UI", glassy);
        flatEarthButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent e, Actor a){
                parent.changeScreen(FLAT_EARTH_UI);
            }
        });

        TextButton cloudFormButton = new TextButton("Cloud-Form-ui", glassy);
        cloudFormButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent e, Actor a){
                parent.changeScreen(CLOUD_FORM_UI);
            }
        });

        table.add(showcaseTitle).uniform();
        table.row().pad(10, 0, 10, 0);
        table.add(titleLabel).uniform();
        table.row();
        table.add(flatEarthButton);
        table.row();
        table.add(cloudFormButton);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
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
