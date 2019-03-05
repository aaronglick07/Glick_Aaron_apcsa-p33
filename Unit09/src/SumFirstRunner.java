import java.util.ArrayList;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class SumFirstRunner
{
	public static void main( String args[] )
	{				
		ListSumFirst sum = new ListSumFirst();
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
		System.out.println(sum.go(list));
		//[10,9,8,7,6,5,4,3,2,1,-99]
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
		System.out.println(sum.go(list));
	}
}