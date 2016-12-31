package com.stewesho.wator;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;

/**
* Class that stores the grid/planet
* Each tile is represented by one (1) pixel when rendered
**/

public class Grid{

	private final int WIDTH;
	private final int HEIGHT;
	private Tile[][] grid;
	private Pixmap pixmap; //used to render the world
	private Texture gridTexture;
	//stores fish and shark entities
	Array<Tile> sharkList;
	Array<Tile> fishList;

	public Grid(int width, int height){
		this.WIDTH = width;
		this.HEIGHT = height;
		this.grid = new Tile[this.WIDTH][this.HEIGHT];
		this.pixmap = new Pixmap(this.WIDTH, this.HEIGHT, Format.RGBA8888);
		this.sharkList = new Array();
		this.fishList = new Array();

		initGrid();
	}

	private void initGrid(){
		for (int w = 0; w < this.WIDTH; w++){
			for (int h = 0; h < this.HEIGHT; h++){

				//randomly assigns a fish, shark, or water to each tile;
				//the higher the floats in the inequality statements are, the lower the chances of spawning the animal
				float tileTypeGen = MathUtils.randomTriangular();
				if (tileTypeGen < -0.85f){ //chances for spawning fish
					grid[w][h] = new Fish(w, h, this.WIDTH, this.HEIGHT);
					this.fishList.add(grid[w][h]);
					Gdx.app.log("Fish", fishList.size + " fishes generated");
				}
				else if (tileTypeGen > 0.875f){ //chances for spawning sharks
					grid[w][h] = new Shark(w, h, this.WIDTH, this.HEIGHT);
					this.sharkList.add(grid[w][h]);
					Gdx.app.log("Shark", sharkList.size + " sharks generated");
				}
				else
					grid[w][h] = new Water(w, h, this.WIDTH, this.HEIGHT);

			}
		}
		Gdx.app.log("Fish", fishList.size + " fishes generated");
		Gdx.app.log("Shark", sharkList.size + " sharks generated");
	}

	public Texture render(){
		//create pixmap based on grid
		for (int w = 0; w < this.WIDTH; ++w){
			for (int h = 0; h < this.HEIGHT; ++h){
				try{
					this.pixmap.drawPixel(w, h, this.grid[w][h].getColorInt());
				} catch(NullPointerException e){
					Gdx.app.error("ERROR", "Error creating pixmap", e);
				}
			}
		}

		//convert to texture, overriding the previous chronon's texture,
		//      and return the Texture
		//the texture is *technically* rendered in main.java
		try{
			this.gridTexture.dispose();
		} catch(NullPointerException e){
			Gdx.app.error("ERROR", "Error disposing map texture", e);
		}
		this.gridTexture = new Texture(this.pixmap);

		return this.gridTexture;
	}

	public void swap(int x1, int y1, int x2, int y2){
		//tried using modulo and map width; didnt work
		while (x1 >= this.WIDTH)
			x1 -= this.WIDTH;
		if (x1 < 0)
			x1 += this.WIDTH;
		///////////////
		while (y1 >= this.HEIGHT)
			y1 -= this.HEIGHT;
		if (y1 < 0)
			y1 += this.HEIGHT;
		///////////////
		while (x2 >= this.WIDTH)
			x2 -= this.WIDTH;
		if (x2 < 0)
			x2 += this.WIDTH;
		///////////////
		while (y2 >= this.HEIGHT)
			y2 -= this.HEIGHT;
		if (y2 < 0)
			y2 += this.HEIGHT;
		///////////////
		Tile placeholder = this.grid[x1][y1];
		this.grid[x1][y1] = this.grid[x2][y2];
		this.grid[x2][y2] = placeholder;
	}

	public void disposeResources(){
		this.gridTexture.dispose();
		this.pixmap.dispose();
	}

	/**
	* Getters
	**/
	public int getWidth(){ return this.WIDTH; }
	public int getHeight(){ return this.HEIGHT; }
	public Tile get(int x, int y){
		x = MathUtils.clamp(x, 0, this.WIDTH - 1);
		y = MathUtils.clamp(y, 0, this.HEIGHT - 1);
		return this.grid[x][y];
	}
	public Pixmap getPixmap(){ return this.pixmap; }
	public Tile[][] getGrid(){ return this.grid; }
	public Array<Tile> getSharkList(){ return this.sharkList; }
	public Array<Tile> getFishList(){ return this.fishList; }
}
