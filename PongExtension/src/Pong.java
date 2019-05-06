
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys;
	private ArrayList<Break> Breaks;
	private int level = -1;
	private int countDown = -1;
	private int ballHitCountdown = -1;
	private final int RESET_BALL_FRAMES = 120;
	private final int HIT_IGNORE_FRAMES = 40;
	private double speedMultiplyer = 1;
	private boolean ballHit;
	private final static int BLOCK_WIDTH = 40;
	private final static int BLOCK_HEIGHT = 90;

	Random rand = new Random();

	public Pong() {
		ball = new Ball(TheGame.WIDTH/ 2, TheGame.HEIGHT / 2, 10, 10, Color.black, 2, -2);
		paddle = new Paddle(TheGame.WIDTH / 2, 400, 40, 40, Color.DARK_GRAY, 7);
		Breaks = new ArrayList<>();
		nextLevel();

		keys = new boolean[4];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); 
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void nextLevel() {
		level++;
		load(levels[level]);
	}

	public void load(Break[] level) {
		Breaks.clear();
		for (Break c : level) {
			Breaks.add(c);
		}
	}

	public void paint(Graphics window) {
		ball.moveAndDraw(window);
		paddle.draw(window);
		boolean levelOver = true;
		for (Break c : Breaks) {
			if (c.isVisible) {
				c.draw(window);
				c.isColliding(ball, window);
				levelOver = false;
			}
		}
		if(levelOver) {
			nextLevel();
		}

		
		if (ball.getY() <= 0) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.getX() <= 0) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.getX() >= 800 - 40) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		if (ball.getY() >= 600 - 40) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (!ballHit && ball.getX() < paddle.getX() + paddle.getWidth() && ball.getX() + ball.getWidth() > paddle.getX()
				&& ball.getY() < paddle.getY() + paddle.getHeight() && ball.getY() + ball.getHeight() > paddle.getY()) {
			ball.setXSpeed(-ball.getXSpeed());
			if (ball.getY() < paddle.getY() + paddle.getHeight() / 2) {
				ball.setYSpeed(-2);
			} else {
				ball.setYSpeed(2);
			}
			if (ball.getX() < paddle.getX() + paddle.getWidth() / 2) {
				ball.setXSpeed(-2);
			} else {
				ball.setXSpeed(2);
			}

			ballHit = true;
			ballHitCountdown = HIT_IGNORE_FRAMES;
		}

		if (countDown > 0) {
			countDown--;
		}
		if (countDown == 0) {
			ball.setXSpeed(rand.nextBoolean() ? 2 : -2);
			ball.setYSpeed(-2);
			countDown = -1;
			speedMultiplyer = 1;
		}

		if (ballHitCountdown > 0) {
			ballHitCountdown--;
		}
		if (ballHitCountdown == 0) {
			ballHit = false;
			ballHitCountdown = -1;
		}
		if (keys[0]) {
			if (paddle.getY() > 0) {
				paddle.moveUpAndDraw(window);
			}
		}
		if (keys[1]) {
			if (paddle.getX() > 0) {
				paddle.moveLeftAndDraw(window);
			}
		}
		if (keys[2]) {
			if (paddle.getY() < TheGame.HEIGHT - paddle.getHeight() * 2) {
				paddle.moveDownAndDraw(window);
			}
		}
		if (keys[3]) {
			if (paddle.getX() < TheGame.WIDTH - paddle.getWidth() * 2) {
				paddle.moveRightAndDraw(window);
			}
		}

	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'A':
			keys[1] = true;
			break;
		case 'S':
			keys[2] = true;
			break;
		case 'D':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'A':
			keys[1] = false;
			break;
		case 'S':
			keys[2] = false;
			break;
		case 'D':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch (Exception e) {
		}
	}
	static private final Break[] level0 = { new Break(50, 10, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(150, 10, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(250, 10, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(350, 10, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(450, 10, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(550, 10, BLOCK_HEIGHT, BLOCK_WIDTH),  new Break(650, 10, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(10, 60, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(10, 110, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(10, 160, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(10, 210, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(10, 260, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(10, 310, BLOCK_HEIGHT, BLOCK_WIDTH)
			,new Break(10, 360, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(10, 410, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(10, 460, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(680, 60, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(680, 110, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(680, 160, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(680, 210, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(680, 260, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(680, 310, BLOCK_HEIGHT, BLOCK_WIDTH)
			,new Break(680, 360, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(680, 410, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(680, 460, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(50, 510, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(150, 510, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(250, 510, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(350, 510, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(450, 510, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(550, 510, BLOCK_HEIGHT, BLOCK_WIDTH),  new Break(650, 510, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(120, 60, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(220, 60, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(320, 60, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(420, 60, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(520, 60, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(580, 110, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(580, 160, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(580, 210, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(580, 260, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(580, 310, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(580, 360, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(580, 410, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(580, 460, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(120, 110, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 110, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 160, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(120, 210, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 260, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(120, 310, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 360, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(120, 410, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 460, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 460, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(220, 460, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(320, 460, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(420, 460, BLOCK_HEIGHT,BLOCK_WIDTH),};
	static private final Break[] level1 = { new Break(50, 10, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(150, 10, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(250, 10, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(350, 10, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(450, 10, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(550, 10, BLOCK_HEIGHT, BLOCK_WIDTH),  new Break(650, 10, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(10, 60, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(10, 110, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(10, 160, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(10, 210, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(10, 260, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(10, 310, BLOCK_HEIGHT, BLOCK_WIDTH)
			,new Break(10, 360, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(10, 410, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(10, 460, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(680, 60, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(680, 110, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(680, 160, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(680, 210, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(680, 260, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(680, 310, BLOCK_HEIGHT, BLOCK_WIDTH)
			,new Break(680, 360, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(680, 410, BLOCK_HEIGHT, BLOCK_WIDTH), 
			new Break(680, 460, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(50, 510, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(150, 510, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(250, 510, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(350, 510, BLOCK_HEIGHT, BLOCK_WIDTH), new Break(450, 510, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(550, 510, BLOCK_HEIGHT, BLOCK_WIDTH),  new Break(650, 510, BLOCK_HEIGHT, BLOCK_WIDTH),
			new Break(120, 60, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(220, 60, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(320, 60, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(420, 60, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(520, 60, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(580, 110, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(580, 160, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(580, 210, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(580, 260, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(580, 310, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(580, 360, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(580, 410, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(580, 460, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(120, 110, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 110, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 160, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(120, 210, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 260, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(120, 310, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 360, BLOCK_HEIGHT,BLOCK_WIDTH),new Break(120, 410, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 460, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(120, 460, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(220, 460, BLOCK_HEIGHT,BLOCK_WIDTH),
			new Break(320, 460, BLOCK_HEIGHT,BLOCK_WIDTH), new Break(420, 460, BLOCK_HEIGHT,BLOCK_WIDTH),};
	static private final Break[][] levels = { level0, level1};
}