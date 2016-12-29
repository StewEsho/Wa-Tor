package com.stewesho.wator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera cam;
	WorldManager world;

	@Override
	public void create () {
		batch = new SpriteBatch();
		world = new WorldManager(40, 40);
		cam = new OrthographicCamera(50, 50);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.250f, 0.250f, 0.300f, 1.000f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);
		batch.begin();

		batch.draw(world.run(), -world.getMap().getWidth()/2, -world.getMap().getHeight()/2);

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		world.dispose();
	}
}
