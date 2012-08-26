/* Author: Ming Lu
 * Date : 08/22/2012
 * Description: game logic control
 */
package edu.indiana.cs.control;
import edu.indiana.cs.element.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class control extends Applet implements Runnable, KeyListener {
	
	Image image;
	Graphics graphic;
	
	Thread th= new Thread(this);
	boolean running = true;
	Ball ball = new Ball(100,100,5,10,Color.white);
	Paddle paddle = new Paddle(250,250,20,150,Color.white);
	Brick brick = new Brick(400, 200, 20, 20, Color.white);
	
	public void init(){
		setSize(700, 700);
		addKeyListener(this);
	}
	
	public void run(){
		while(running){
			ball.move(getSize(), paddle, brick);
			paddle.move(getSize().height);
			repaint();
			try{
				Thread.sleep(20);
			} catch (InterruptedException ex) {
				System.out.print(ex.getStackTrace());
			}
			
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getSize().width, this.getSize().height);
		ball.draw(g);
		paddle.draw(g);
		brick.draw(g);		
	}
	//Double buffered.
	public void update(Graphics g){
		 if (image == null){
			 image = createImage(this.getSize().width, this.getSize().height);
			 graphic = image.getGraphics();
		 }
		 
		 graphic.setColor(this.getBackground());
		 graphic.fillRect(0, 0, this.getSize().width, this.getSize().height);
		 graphic.setColor(this.getForeground());
		 
		 paint(graphic);
		 g.drawImage(image, 0, 0, this);
	}
	
	public void start(){
		th.start();
	}
	
	public void stop(){
		running = false;
	}
	
	public void destory(){
		running = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP)
			paddle.directUp = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			paddle.directDown = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP)
			paddle.directUp = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			paddle.directDown = false;
	}
}
