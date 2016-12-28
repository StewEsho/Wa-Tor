package com.stewesho.wator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Grid map;

	@Override
	public void create () {
		batch = new SpriteBatch();
		map = new Grid(255, 255);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.250f, 0.250f, 0.250f, 1.000f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(map.render(), 25, 25);

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		map.disposeResources();
	}
}
