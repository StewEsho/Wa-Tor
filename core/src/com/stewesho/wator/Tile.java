package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;

/**
* Base class for the tiles that will occupy the grid of wator
* Shark and Fish classes derived from this class
**/
public class Tile{

	protected int x;
	protected int y;
	protected int mapWidth;
	protected int mapHeight;
	protected boolean isAlive;
	protected boolean hasMoved; //set to true after run through
	protected Color color;

	protected Tile(int x, int y, int width, int height, boolean isAlive){
		this.x = x;
		this.y = y;
		this.mapWidth = width;
		this.mapHeight = height;
		this.isAlive = isAlive;
		this.hasMoved = false;
	}

	protected void updatePosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	protected void run(Grid grid){} //declared in Creature.java

	public Color getColor(){ return this.color; }
	public int getColorInt(){ return Color.rgba8888(this.color); }
	public int getX(){ return this.x; }
	public int getY(){ return this.y; }
}
