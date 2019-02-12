//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class CountPairs
{
	public static int pairCounter( String str )
	{ 
		int count = 0;
		char one;
		char two;
		for (int i = 0; i < str.length() -1; i++) {
			one = str.charAt(i);
			two = str.charAt(i+1);
			if (one == two) {
				count++;
			}
		}
		return count;
	}
}