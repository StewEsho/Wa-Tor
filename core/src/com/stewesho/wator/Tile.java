package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

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
		switch(direction){
		case 0:
			this.y += 1;
			break;
		case 1:
			this.x += 1;
			break;
		case 2:
			this.y -= 1;
			break;
		case 3:
			this.x -= 1;
			break;
		}
		this.x = (this.x + width - 1) % width;
		this.y = (this.y + height - 1) % height;
	}

	protected void run(Grid grid){} //declared in Creature.java

	public Color getColor(){ return this.color; }
	public int getColorInt(){ return Color.rgba8888(this.color); }
	public int getX(){ return this.x; }
	public int getY(){ return this.y; }
	public String getName(){ return this.name; }
	public boolean hasMoved(){ return this.hasMoved; }
}
