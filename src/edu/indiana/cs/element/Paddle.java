/* Author: Ming Lu
 * Date: 08/22/2012
 * Description: Paddle class for Java Ball/Paddle Game
 */

package edu.indiana.cs.element;
import java.awt.*;

public class Paddle {
	//set parameters for x/y position ,moving direction and width/height of paddle
	private int posX, posY, width, height;
	private Color color;
	public boolean directUp = false;
	public boolean directDown = false;
	
	//Constructor with x/y/w/h
	public Paddle (int posX, int posY, int width, int height, Color color){
		this.posX=posX;
		this.posY=posY;
		this.width=width;
		this.height=height;
		this.color=color;
	}
	//Draw the paddle object with color input
	public void draw (Graphics g){
		g.setColor(color);
		g.fillRect(posX, posY, width, height);
	}
	//Move method with limit
	public void move (int maxHeight){
		if (directUp)
			posY-=5;
		if (directDown)
			posY+=5;
		if (posY < 0)
			posY= 0;
		if (posY + this.height> maxHeight)
			posY= maxHeight- this.height;
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
