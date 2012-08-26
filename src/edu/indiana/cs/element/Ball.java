/* Author: Ming Lu
 * Date: 08/22/2012
 * Description: Ball class
 */

package edu.indiana.cs.element;
import java.awt.*;

public class Ball {
	//set parameters for x/y position ,moving speed and radius of ball
	private int posX, posY, speedX, speedY, radius;
	private Color color;
	
	//Constructor with x/y/radius/speed/color
	public Ball (int posX, int posY, int speed, int radius, Color color){
		this.posX=posX;
		this.posY=posY;
		this.speedX=speed;
		this.speedY=speed;
		this.radius=radius;
		this.color=color;
	}
	//Draw the ball object with color input, upper left corner of the oval to be filled
	public void draw (Graphics g){
		g.setColor(color);
		g.fillOval(posX-radius, posY-radius, radius*2, radius*2); //x, y position are the center of the ball
	}
	//Move method with dimension
	public void move (Dimension dim, Paddle paddle, Brick brick){
		posX += speedX;
		posY += speedY;
		
		if (posX < 0)
			speedX = Math.abs(speedX);
		if (posX > dim.width)
			speedX = -Math.abs(speedX);
		if (posY < 0)
			speedY = Math.abs(speedY);
		if (posY > dim.height)
			speedY = -Math.abs(speedY);
		
		if (posY >= paddle.getPosY() && posY <= paddle.getPosY() +paddle.getHeight() ){
			if (posX + radius >= paddle.getPosX() && posX + radius < paddle.getPosX() + paddle.getWidth()){
				speedX = -Math.abs(speedX);
				brick.interact =true;
			}
			if (posX - radius == paddle.getPosX() + paddle.getWidth()){
				speedX = Math.abs(speedX);
				brick.interact= true;
			}				
		}
		
	}
	
}
