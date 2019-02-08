//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

import java.util.Scanner;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		//add test cases
		Scanner keyboard = new Scanner(System.in);
		   
		System.out.println("Enter your first word :: ");
		String one = keyboard.nextLine();
		   
		System.out.println("Enter your second word :: ");
		String two = keyboard.nextLine();
		
		StringEquality equals = new StringEquality();
		equals.setWords(one, two);
		equals.checkEquality();
		System.out.println(equals.toString());
	}
}