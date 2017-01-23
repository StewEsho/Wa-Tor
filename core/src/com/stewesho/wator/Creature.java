package com.stewesho.wator;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;

public abstract class Creature extends Tile{
	protected int breedingTime; //in chronons/ticks
	protected int timeSinceBreeding; //in chronons/ticks
	protected int deltaX; //deltaX/Y used to determine directon of movement
	protected int deltaY;
	protected int backDir;
	protected int dir;

	protected Creature(int x, int y, int width, int height){
		super(x, y, width, height, true);
		this.backDir = MathUtils.random(4);
	}

	@Override
	protected void run(Grid grid){
		//breeding time calculations
		this.timeSinceBreeding += 1;
		this.willBreed = false;
		if(this.timeSinceBreeding > this.breedingTime){
			this.willBreed = true; //uncomment to enable breeding
			this.timeSinceBreeding = 0;
		}

		do{
			this.dir = MathUtils.random(4);
		} while (this.dir == this.backDir);
		this.backDir = (this.dir - 2) % 4;
		this.hasMoved = false;
		if(grid.get(this.x, this.y, this.dir).getName() == "Water"){ //checks if it is empty
			this.updatePosition(this.dir, grid.getWidth(), grid.getHeight()); //updates position
			this.hasMoved = true;
		}
	}
}
