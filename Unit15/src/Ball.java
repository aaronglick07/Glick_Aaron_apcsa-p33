//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	//add other Ball constructors

	public Ball(int x, int y) {
		super(x, y);
	}
	
	public Ball(int x, int y, int w, int h) {
		super(x, y, w, h, Color.white);
	}
	
	public Ball(int x, int y, int w, int h, Color a) {
		super(x, y, w, h, a);
	}
	
	public Ball(int x, int y, int w, int h, Color a, int thexs, int theys) {
		super(x, y, w, h, a);
		setXSpeed(thexs);
		setYSpeed(theys);
	}
	
	//add the set methods
	
	public void setXSpeed(int xspeed) {
		xSpeed = xspeed;
	}
	
	public void setYSpeed(int yspeed) {
		ySpeed = yspeed;
	}
   
   public void moveAndDraw(Graphics window)
   {
   	  draw(window, Color.WHITE);
      setX(getX()+xSpeed);
      setY(getY() + ySpeed);
      draw(window, this.getColor());
   }
   
	public boolean equals(Object obj)
	{
		Ball myball = (Ball) obj;
		if (myball.getX() == this.getX() && myball.getY() == this.getY() 
				&& myball.getWidth() == this.getWidth() 
				&& myball.getHeight() == this.getHeight() && myball.getColor() == this.getColor()
				&& myball.getXSpeed() == this.getXSpeed() && myball.getYSpeed() == this.getYSpeed()) {
			return true;
		}
		return false;
	}  
	
	//add the get methods

	public int getXSpeed() {
		return xSpeed;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}
	
	public boolean didCollideLeft(Object obj) {
		Ball ball = (Ball) obj;
		if (ball.getX() < -20) {
			return true;
		}
		return false;
	}
	
	public boolean didCollideRight(Object obj) {
		Ball ball = (Ball) obj;
		if (ball.getX() > 790) {
			return true;
		}
		return false;
	}
	
	public boolean didCollideTop(Object obj) {
		Ball ball = (Ball) obj;
		if (ball.getY() < 10) {
			return true;
		}
		return false;
	}
	
	public boolean didCollideBottom(Object obj) {
		Ball ball = (Ball) obj;
		if (ball.getY() >= 480) {
			return true;
		}
		return false;
	}
	
	
	//add a toString() method
	
	public String toString() {
		String output =  this.getX() + " " + this.getY() + " " + this.getWidth() 
		+ " " + this.getHeight() + " " + this.getColor() 
		+ " " +  xSpeed + " " + ySpeed;
		return output;
	}
}