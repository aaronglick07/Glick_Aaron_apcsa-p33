//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class Line
{
	public static double getSlope( int x1, int y1, int x2, int y2 )
	{
		double y = y2-y1;
		double x = x2 - x1;
		double m = y/x;
		return m;
	}

}