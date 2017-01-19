package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.Gdx;

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
	protected String name;
	protected boolean willBreed;

	protected Tile(int x, int y, int width, int height, boolean isAlive){
		this.x = x;
		this.y = y;
		this.mapWidth = width;
		this.mapHeight = height;
		this.isAlive = isAlive;
		this.hasMoved = false;
	}

	//EXPLICITLY updates position
	protected void updatePosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	//IMPLICITLY updates position
	/**
	* 0 = north (+1 y)
	* 1 = east (+1 x)
	* 2 = south (-1 y)
	* 3 = west (-1 x)
	*/
	protected void updatePosition(int direction, int width, int height){
		direction = MathUtils.clamp(direction, 0, 3);
		if(direction == 0){
			this.y -= 1;
		} else if(direction == 1){
		 	this.x -= 1;
		} else if(direction == 2){
		 	this.y += 1;
		} else if(direction == 3){
		 	this.x += 1;
		}
		this.y = (this.y + (height)) % height;
		this.x = (this.x + (width)) % width;
	}

	protected void run(Grid grid){} //declared in Creature.java

	public Color getColor(){ return this.color; }
	public int getColorInt(){ return Color.rgba8888(this.color); }
	public int getX(){ return this.x; }
	public int getY(){ return this.y; }
	public String getName(){ return this.name; }
	public boolean hasMoved(){ return this.hasMoved; }
	//getters to be overridden in Creature.java
	public boolean willBreed(){ return false;}
}
