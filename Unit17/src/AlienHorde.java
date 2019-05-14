
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AlienHorde {
	private List<Alien> aliens;
	private boolean moveAble = true;
	private int moveLeft = 10;
	private int moveRight = 0;
	private int moveDown = 10;
	private int moveDownAgain = 10;

	public AlienHorde(int size) {
		aliens = new ArrayList<Alien>();
		int x = 5;
		int y = 10;
		for (int i = 0; i <= size; i++) {
			if (x > 760) {
				x = 5;
				y += 60;
			}
			aliens.add(new Alien(x, y, 40, 40, 4));
			x += 70;
		}
	}

	public void add(Alien al) {
		aliens.add(al);
	}

	public int size() {
		return aliens.size();
	}

	public void drawEmAll(Graphics window) {
		for (Alien alien : aliens) {
			alien.draw(window);
		}
	}

	public void moveEmAll() {
		if (moveAble) {

			if (moveAble) {
				moveAble = false;
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					public void run() {
						moveAble = true;
						timer.cancel();
					}
				}, 250);
			}

			if (moveRight < 10) {
				for (Alien a : aliens) {
					a.move("RIGHT");

				}
				moveRight++;
				return;
			}
			if (moveRight == 10) {
				moveDown = 0;
				moveRight++;
			}
			if (moveDown < 10) {
				for (Alien a : aliens) {
					a.move("DOWN");

				}
				moveDown++;
				return;

			}
			if (moveDown == 10) {
				moveLeft = 0;
				moveDown++;
			}
			if (moveLeft < 10) {
				for (Alien a : aliens) {
					a.move("LEFT");
				}
				moveLeft++;
				return;
			} else if (moveLeft == 10) {
				moveDownAgain = 0;
				moveLeft++;
			}
			if (moveDownAgain < 10) {
				for (Alien a : aliens) {
					a.move("DOWN");
				}
				moveDownAgain++;
				return;
			}
			if (moveDownAgain == 10) {
				moveRight = 0;
				moveDownAgain++;
			}
		}
	}

	public boolean collides(int x, int y, int xW, int yH) {
		for (Alien a : aliens) {
			if (((x >= a.getX() && x <= a.getX() + a.getWidth()) && y + 10 <= a.getY() + a.getHeight()
					&& y + 10 >= a.getY())) {
				return true;
			}
		}
		return false;
	}

	public boolean hitsBottom(int height) {
		for(Alien a: aliens) {
			if (a.getY()+a.getHeight() >= height) {
				return true;
			}
		}
		return false;
	}
	
	public void removeDeadOnes(Bullets bullet) {
		List<Alien> dead = new ArrayList<Alien>();
		List<Ammo> toKill = new ArrayList<Ammo>();
		for (Alien a : aliens) {
			for (Ammo ammo : bullet.getList()) {
				if ((ammo.getX() >= a.getX() && ammo.getX() <= a.getX() + a.getWidth()
						&& ammo.getY() <= a.getY() + a.getHeight() - 10)) {
					dead.add(a);
					toKill.add(ammo);
				}
			}
		}
		bullet.removeAll(toKill);
		aliens.removeAll(dead);
	}

	public String toString() {
		return "";
	}
}
