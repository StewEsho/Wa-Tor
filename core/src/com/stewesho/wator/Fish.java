package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;

/**
* Tile inhabited by a fish will be stored as an object of this class
**/
public class Fish extends Tile{
	private int breedingTime; //in chronons/ticks
	private int timeSinceBreeding; //in chronons/ticks
	private int final nutritionalValue; //amount of energy the fish provides a shark when eaten

	public Fish(int x, int y){
		super (x, y, true);
		this.color = new Color(0.250f, 0.886f, 0.392f, 1.000f); //green
		this.breedingTime = 5;
		this.timeSinceBreeding = 0;
		this.nutritionalValue = 1;
	}

	@Override
	public void run(){

	}

}
