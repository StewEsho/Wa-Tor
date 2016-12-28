package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;

/**
* Base class for the tiles that will occupy the grid of wator
* Shark and Fish classes derived from this class
**/
public class Tile{

	protected int x;
	protected int y;
	protected boolean isAlive;
	protected boolean hasMoved; //set to true after run through
	protected Color color;

	public Tile(int x, int y, boolean isAlive){
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
		this.hasMoved = false;
	}

	public void run(){ /* will be overriden in Shark and Fish */ }

	public Color getColor(){ return this.color; }
	public int getColorInt(){ return Color.rgba8888(this.color); }
}
