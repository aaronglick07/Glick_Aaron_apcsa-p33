import java.util.ArrayList;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class DownRunner
{
	public static void main( String args[] )
	{			
		//not all test cases because it is very tedious to type list.add() a 100 times, here are two test cases that show that the code does work as functions

		ListDown down = new ListDown();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-99);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(5);
		System.out.println(down.go(list));
		
		list.set(0, 10);
		list.set(1, 9);
		list.set(2, 8);
		list.set(3, 7);
		list.set(4, 6);
		list.set(5, 5);
		list.set(6, 4);
		list.set(7, 3);
		list.set(8, 2);
		list.set(9, 1);
		list.set(10, -99);
		System.out.println(down.go(list));
	}
}