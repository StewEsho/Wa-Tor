package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;

/**
* Tile inhabited by a fish will be stored as an object of this class
**/
public class Fish extends Tile{
	public Fish(int x, int y){
		super (x, y, true);
		this.color = new Color(0.250f, 0.886f, 0.392f, 1.000f); //green
	}

	@Override
	public void run(){

	}

}
