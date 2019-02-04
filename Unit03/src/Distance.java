//(c) A+ Computer Science 
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;

	public Distance()
	{
		
	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
	}

	public void calcDistance()
	{
		distance = Math.sqrt(Math.pow(xTwo - xOne, 2) + Math.pow(yTwo - yOne, 2));
	}
	
	public double getDistance()
	{
		return distance;
	}
	
	public void print()
	{
		System.out.println(distance);
	}
	
	//complete print or the toString

	public String toString()
	{
		return "";//System.out.print(String.format("%.3f", distance));
	}
}