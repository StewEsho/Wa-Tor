package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;

/**
* Tile inhabited by a shark will be stored as an object of this class
**/
public class Shark extends Tile{
	public Shark(){
		super (true);
		this.color = new Color(0.250f, 0.470f, 0.886f, 1.000f); //blue
	}

}
