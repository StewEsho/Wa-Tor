package com.stewesho.wator;

import com.badlogic.gdx.graphics.Color;

/**
* Tile inhabited by a shark will be stored as an object of this class
**/
public class Shark extends Tile{
	private int breedingTime; //in chronons/ticks
	private int timeSinceBreeding; //in chronons/ticks
	private int energy; //when energy hits 0, the shark dies

	public Shark(int x, int y, int width, int height){
		super (x, y, width, height, true);
		this.color = new Color(0.250f, 0.470f, 0.886f, 1.000f); //blue
		this.breedingTime = 5;
		this.timeSinceBreeding = 0;
		this.energy = 5;
	}

	@Override
	public void run(){
		updatePosition((x + 1) % this.mapWidth, (y + 1) % this.mapHeight);
	}

}
