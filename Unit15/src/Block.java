//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		setX(0);
		setY(0);
		setWidth(50);
		setHeight(50);
		setColor(Color.RED);
		
	}
	
	public Block(int x, int y){
		setX(x);
		setY(y);
		setWidth(10);
		setHeight(10);
		setColor(Color.WHITE);
	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y, int width, int height){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(Color.RED);
	}
	
	public Block(int x, int y, int width, int height, Color color){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(color);
	}
	
	
   //add the other set methods
	public void setX(int x){
		xPos = x;
		//System.out.println(xPos);
	}
	public void setY(int y){
		yPos = y;
	}
	
	public void setPos(int x, int y){
		xPos = x;
		yPos = y;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}

	public void setColor(Color col)
	{
		color = col;
	}

	public void draw(Graphics window)
	{
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void draw(Graphics window, Color col)
	{
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}
   
	public boolean equals(Object obj)
	{
		if(getX() == ((Block) obj).getX() && getY() == ((Block) obj).getY() && getWidth() == ((Block) obj).getWidth() && getHeight() == ((Block) obj).getHeight()){
			return true;
		}
		return false;
	}   

   //add the other get methods
	public int getX(){
		return xPos;
	}
    
    public int getY(){
    	return yPos;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public int getHeight(){
    	return height;
    }
    
    public Color getColor(){
    	return color;
    }

   //add a toString() method  - x , y , width, height, color
    
    public String toString(){
    	String output = getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
    	return output;
    }
}