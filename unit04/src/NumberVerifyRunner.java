//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		//add in input
		System.out.println("Enter a number::");
		int num = keyboard.nextInt();
		if(NumberVerify.isEven(num) == true) {
			System.out.println("Your number of " + num + " is even");
		}
		if(NumberVerify.isOdd(num) == true) {
			System.out.println("Your number of " + num + " is odd");
		}
		//add in more test cases
	}
}