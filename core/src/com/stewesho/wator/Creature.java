package com.stewesho.wator;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;

public abstract class Creature extends Tile{
	protected int breedingTime; //in chronons/ticks
	protected int timeSinceBreeding; //in chronons/ticks
	protected int deltaX; //deltaX/Y used to determine directon of movement
	protected int deltaY;

	protected Creature(int x, int y, int width, int height){
		super(x, y, width, height, true);
	}

	@Override
	protected void run(Grid grid){
		//breeding time calculations
		this.timeSinceBreeding += 1;
		this.willBreed = false;
		if(this.timeSinceBreeding > this.breedingTime){
			//this.willBreed = true; //uncomment to enable breeding
			this.timeSinceBreeding = 0;
		}

		int dir = MathUtils.random(4);
		this.hasMoved = false;
		if(grid.get(this.x, this.y, dir).getName() == "Water"){ //checks if it is empty
			this.updatePosition(dir, grid.getWidth(), grid.getHeight()); //updates position
			this.hasMoved = true;
		}
	}
}
