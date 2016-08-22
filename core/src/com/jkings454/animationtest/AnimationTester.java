package com.jkings454.animationtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationTester extends ApplicationAdapter {
	SpriteBatch batch;
	Texture tux;
	TextureRegion[] idleFrames;
	TextureRegion[] walkFrames;
	TextureRegion[] jumpFrames;
	Animation walkAnim;
	Animation idleAnim;
	Animation jumpAnim;
	TextureRegion currentFrame;
	
	float stateTime;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		tux = new Texture("tux_from_linux.png");
		TextureRegion[][] tmp = TextureRegion.split(tux, tux.getWidth() / 3, tux.getHeight() / 9);
		walkFrames = new TextureRegion[3];
		idleFrames = new TextureRegion[3];
		jumpFrames = new TextureRegion[3];
		int index = 0;
		for (int i = 0; i < 3; i++){
			walkFrames[index] = tmp[1][i];
			idleFrames[index] = tmp[0][i];
			jumpFrames[index] = tmp[2][i];
			index++;
		}
		walkAnim = new Animation(0.1f, walkFrames);
		idleAnim = new Animation(0.1f, idleFrames);
		jumpAnim = new Animation(0.1f, jumpFrames);
		stateTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		batch.begin();
		currentFrame = walkAnim.getKeyFrame(stateTime, true);
		batch.draw(currentFrame, 50, 50);
		currentFrame = idleAnim.getKeyFrame(stateTime, true);
		batch.draw(currentFrame, 100, 50);
		currentFrame = jumpAnim.getKeyFrame(stateTime, true);
		batch.draw(currentFrame, 150, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		tux.dispose();
	}
}
