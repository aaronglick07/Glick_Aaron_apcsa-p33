//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
      speed =5;
   }


   //add the other Paddle constructors
   public Paddle(int x, int y){
	   super(x,y);
   }
   public Paddle(int x,int y, int w, int h){
	   super(x,y,w,h);
   }

   public Paddle(int x, int y, int s){
	   super(x,y);
	   setSpeed(s);
   }
   public Paddle(int x, int y, int w, int h, int s){
	   super(x,y,w,h);
	   setSpeed(s);
   }
   public Paddle(int x, int y, int w, int h, Color c, int s){
	   super(x,y,w,h,c);
	   setSpeed(s);
   }
   public void setSpeed(int s){
	   speed = s;
   }




   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.white);
	   setPos(getX(), getY() - getSpeed());
	   draw(window,getColor());

   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.white);
	   setPos(getX(), getY() + getSpeed());
	   draw(window,getColor());

   }

   //add get methods
   public int getSpeed(){
	   return speed;
   }
   
   //add a toString() method
   public String toString(){
	   return this.getX() + " " + this.getY() + " " + this.getWidth() + " " + this.getHeight() + " " + this.getColor() + " " + speed;
   }
}