package com.stewesho.wator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Grid map;
	OrthographicCamera cam;

	@Override
	public void create () {
		batch = new SpriteBatch();
		map = new Grid(1000, 1000);
		cam = new OrthographicCamera(map.getWidth() * 1.0625f, map.getHeight() * 1.0625f);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.250f, 0.250f, 0.300f, 1.000f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);
		batch.begin();

		batch.draw(map.render(), -map.getWidth()/2, -map.getHeight()/2);

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		map.disposeResources();
	}
}
