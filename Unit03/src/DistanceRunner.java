//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		//add test cases	
		Distance math = new Distance();	
		math.setCoordinates(12, 16, 14, 18);
		math.calcDistance();
		math.print();
	}
}