/* Author: Ming Lu
 * Date: 08/22/2012
 * Description: Paddle class for Java Ball/Paddle Game
 */

package edu.indiana.cs.element;
import java.awt.*;

public class Brick {
	//set parameters for x/y position ,moving direction and width/height of brick
	private int posX, posY, width, height;
	private Color color;
	public Boolean interact = false;
	
	//Constructor with x/y/w/h
	public Brick (int posX, int posY, int width, int height, Color color){
		this.posX=posX;
		this.posY=posY;
		this.width=width;
		this.height=height;
		this.color=color;
	}
	//Draw the paddle object with color input
	public void draw (Graphics g){
		if (interact == false){
			g.setColor(color);
			g.fillRect(posX, posY, width, height);
		}
	}

	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
