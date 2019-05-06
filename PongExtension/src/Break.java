import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Break extends Block{
	boolean isVisible;
	
	public Break(){
		super();
		isVisible = true;
	}
	public Break(int x, int y, int width, int height){
		super(x,y,width,height,getRandomColor());
		isVisible = true;
	}
	public boolean isColliding(Ball ball, Graphics window) {
		if (ball.getX() < getX() + getWidth() && ball.getX() + ball.getWidth() > getX()
				&& ball.getY() < getY() + getHeight() && ball.getY() + ball.getHeight() > getY()) {
			ball.setYSpeed(-ball.getYSpeed());
			overDraw(window);
			breakBlock();
		}
		return false;
	}

	public void breakBlock() {
		isVisible = false;
	}

	@Override
	public void draw(Graphics window) {
		if (isVisible) {
			super.draw(window);
		}
	}
	
	public static Color getRandomColor() {
		Random rand = new Random();
		return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}

}
