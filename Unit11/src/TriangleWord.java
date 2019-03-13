//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWord
{
	//instance variables and constructors could be present, but are not necessary
		
	public static void printTriangle(String word)
	{
		String newWord = "";
		for (int i = word.length(); i > 0; i--) {
			for (int j = 0; j < i; j++) {
				newWord = word.substring(0, j+1);
				System.out.println(newWord);
			}
		}
	}
}