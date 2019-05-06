
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {
	
	private int speed;

	public Paddle() {
		super(10, 10, 10, 10, Color.ORANGE);
		this.speed = 5;
	}

	public Paddle(int x, int y) {
		super(x, y, 10, 10, Color.ORANGE);
		setSpeed(5);
	}
	
	public Paddle(int x, int y, int speed) {
		super(x, y, 10, 10, Color.ORANGE);
		setSpeed(speed);
	}

	public Paddle(int x, int y, int height, int width) {
		super(x, y, height, width, Color.ORANGE);
		setSpeed(5);
	}
	
	public Paddle(int x, int y, int height, int width, int speed) {
		super(x, y, height, width, Color.ORANGE);
		setSpeed(speed);
	}
	
	public Paddle(int x, int y, int height, int width, Color c) {
		super(x, y, height, width, c);
		setSpeed(5);
	}
	
	public Paddle(int x, int y, int height, int width, Color c, int speed) {
		super(x, y, height, width, c);
		setX(x);
		setSpeed(speed);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	

	public void moveUpAndDraw(Graphics window) {
		overDraw(window);
		setY(getY() - speed);
		draw(window);
	}

	public void moveDownAndDraw(Graphics window) {
		overDraw(window);
		setY(getY() + speed);
		draw(window);

	}
	
	public void moveLeftAndDraw(Graphics window) {
		overDraw(window);
		setX(getX() - speed);
		draw(window);
	}

	public void moveRightAndDraw(Graphics window) {
		overDraw(window);
		setX(getX() + speed);
		draw(window);

	}

	@Override
	public String toString() {
		
		return super.toString() + " | " + getSpeed();
	}
	
}