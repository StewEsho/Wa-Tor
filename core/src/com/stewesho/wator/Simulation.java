package com.stewesho.wator;

import com.badlogic.gdx.Gdx;

//managers the logic behind each chronon on Wa-Tor's grid
public class Simulation{
	//simulates one chronon by iterating through each tile in the ocean
	public void runChronon(Grid grid){
		for (int x = 0; x < grid.getWidth(); ++x){
			for (int y = 0; y < grid.getHeight(); ++y){
				Tile temp = grid.get(x, y);
				temp.run();
				grid.getGrid()[x][y] = grid.get(temp.getX(), temp.getY());
				grid.getGrid()[temp.getX()][temp.getY()] = temp;
			}
		}
		Gdx.app.log("simulation", "Chronon complete!");
	}
}
