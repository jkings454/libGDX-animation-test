package com.jkings454.animationtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationTester extends ApplicationAdapter {
	SpriteBatch batch;
	Texture tux;
	TextureRegion[] walkFrames;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		tux = new Texture("tux_from_linux.png");
		TextureRegion[][] tmp = TextureRegion.split(tux, tux.getWidth(), tux.getHeight());
		walkFrames = new TextureRegion[9];
		int index = 0;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				walkFrames[index++] = tmp[i][j];
			}
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(tux, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		tux.dispose();
	}
}
