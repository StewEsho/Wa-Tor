package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Gdx;

/**
* Tile inhabited by a fish will be stored as an object of this class
**/
public class Fish extends Creature{
	private final int nutritionalValue; //amount of energy the fish provides a shark when eaten

	public Fish(int x, int y, int width, int height){
		super(x, y, width, height);
		this.color = new Color(0.250f, 0.886f, 0.392f, 1.000f); //green
		this.breedingTime = 5;
		this.timeSinceBreeding = 0;
		this.nutritionalValue = 1;
	}

	public void run(){
		super.run();
	}

}
