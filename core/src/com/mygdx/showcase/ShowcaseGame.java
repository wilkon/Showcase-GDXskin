package com.mygdx.showcase;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.showcase.screens.CloudFormScreen;
import com.mygdx.showcase.screens.FlatEarthScreen;
import com.mygdx.showcase.screens.GalleryScreen;

import static com.mygdx.showcase.ScreenViewConstants.*;

public class ShowcaseGame extends Game {
	SpriteBatch batch;
	Texture img;
	private GalleryScreen gallery;

	@Override
	public void create () {
		gallery = new GalleryScreen(this);
		setScreen(gallery);
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void changeScreen(int screen){
		switch(screen){
			case GALLERY:
				if(gallery == null) gallery = new GalleryScreen(this);
				this.setScreen(gallery);
				break;
			case FLAT_EARTH_UI:
				this.setScreen(new FlatEarthScreen(this));
				break;
			case CLOUD_FORM_UI:
				this.setScreen(new CloudFormScreen(this));
				break;
			default : break;
		}
	}
}
