package com.stewesho.wator;

import com.badlogic.gdx.math.MathUtils;

/**
* Class that stores the grid/planet
* Each tile is represented by one (1) pixel when rendered
**/

public class Grid{

	private final int WIDTH;
	private final int HEIGHT;
	private Tile[][] grid;

	public Grid(int width, int height){
		this.WIDTH = width;
		this.HEIGHT = height;
		grid = new Tile[this.WIDTH][this.HEIGHT];
	}

	private void initGrid(){
		for (int w = 0; w < this.WIDTH; ++w){
			for (int h = 0; h < this.HEIGHT; ++h){

				//randomly assigns a fish, shark, or water to each tile;
				int tileType = MathUtils.random(2);
				switch (tileType){
				case 0:
					grid[w][h] = new Water(w, h);
					break;
				case 1:
					grid[w][h] = new Fish(w, h);
					break;
				case 2:
					grid[w][h] = new Shark(w, h);
					break;
				}

			}
		}
	}
}
