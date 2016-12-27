package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;

/**
* Base class for the tiles that will occupy the grid of wator
* Shark and Fish classes derived from this class
**/
public abstract class Tile{

	protected boolean isAlive;
	protected Color color;

	public Tile(boolean isAlive){
		this.isAlive = isAlive;
	}

}
