//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		//ask for name and size
		System.out.println("What is the name of the first monster");
		String firstname = keyboard.nextLine();
		
		System.out.println("What is the size of the first monster");
		int firstSize = keyboard.nextInt();
		//instantiate monster one
		
		//ask for name and size
		System.out.println("What is the name of the second monster");
		String secondname = keyboard.next();
		
		System.out.println("What is the size of the second monster");
		int secondSize = keyboard.nextInt();
		//instantiate monster two
		Monster m = new Skeleton(firstSize, firstname);
		Monster mon = new Skeleton(secondSize, secondname);
		System.out.println("Monster 1 - " + m);
		System.out.println("Monster 2 - " + mon);
		if(m.isBigger(mon)) {
			System.out.println("Monester one is the bigger monster");
		}
		else if(mon.isBigger(m)) {
			System.out.println("Monester two is the bigger monster");
		}
		if(m.namesTheSame(mon) || mon.namesTheSame(m)) {
			System.out.println("The monsters have the same name");
		}
		else{
			System.out.println("The monsters do not have the same name");
		}
	}
}