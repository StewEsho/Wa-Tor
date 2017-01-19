package com.stewesho.wator;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;

public class WorldManager{
	Grid map;
	Simulation sim;

	public WorldManager(int width, int height){
		this.map = new Grid(width, height);
		this.sim = new Simulation();
	}

	public Texture run(){
		this.sim.runChronon(this.map);
		return this.map.render();
	}

	public Grid getMap(){ return this.map; }

	public void dispose(){
		this.map.disposeResources();
	}

}
