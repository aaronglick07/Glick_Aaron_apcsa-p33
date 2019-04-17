//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables
	private int xSpeed = 0;
	private int ySpeed = 0;
   public SpeedUpBall()
   {
	   super();

   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);

   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {

	   super(x,y,xSpd,ySpd);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht, Color.black, xSpd,ySpd);

   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {

	   super(x,y,wid,ht,col,xSpd,ySpd);


   }

   public void setXSpeed( int xSpd )
   {

	   int add = 1;
	   if(xSpd < 0) add= -1;
	   super.setXSpeed(xSpd + add);
   }

   public void setYSpeed( int ySpd )
   {
	   int add = 1;
	   if(ySpd < 0) add= -1;
	   super.setYSpeed(ySpd + add);

   }
}

