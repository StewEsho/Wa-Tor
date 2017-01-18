package com.stewesho.wator;

import com.badlogic.gdx.Gdx;

//managers the logic behind each chronon on Wa-Tor's grid
public class Simulation{
	//simulates one chronon by iterating through each tile in the ocean
	public void runChronon(Grid grid){
		for (Tile s : grid.getSharkList()){
			int x = s.getX();
			int y = s.getY();
			s.run(grid);
			grid.getGrid()[s.getX()][s.getY()] = s;
			if(s.hasMoved())
				grid.getGrid()[x][y] = new Water(x, y, grid.getWidth(), grid.getHeight());
		}

		for (Tile f : grid.getFishList()){
			int x = f.getX();
			int y = f.getY();
			f.run(grid);
			grid.getGrid()[f.getX()][f.getY()] = f;
			if(f.hasMoved())
				grid.getGrid()[x][y] = new Water(x, y, grid.getWidth(), grid.getHeight());
		}


	}
}
