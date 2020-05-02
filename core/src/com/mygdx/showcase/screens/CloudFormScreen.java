package com.mygdx.showcase.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.showcase.ShowcaseGame;

import static com.mygdx.showcase.ScreenViewConstants.GALLERY;

public class CloudFormScreen implements Screen {
    ShowcaseGame parent;
    Stage stage;

    public CloudFormScreen(ShowcaseGame parent){
        this.parent = parent;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table layout = new Table();
        layout.setFillParent(true);
        stage.addActor(layout);

        Skin skin = new Skin(Gdx.files.internal("cloud-form/cloud-form-ui.json"));

        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent e, Actor a){
                parent.changeScreen(GALLERY);
            }
        });

        layout.add(backButton);
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
