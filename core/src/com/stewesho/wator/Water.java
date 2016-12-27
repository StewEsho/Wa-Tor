package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;

/**
* Tile uninhabited by an animal
**/
public class Water extends Tile{
	public Water(int x, int y){
		super (x, y, false);
		this.color = new Color(0.250f, 0.250f, 0.250f, 1.000f); //black
	}
}
