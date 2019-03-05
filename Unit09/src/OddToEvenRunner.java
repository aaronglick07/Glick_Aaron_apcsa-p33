import java.util.ArrayList;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class OddToEvenRunner
{
	public static void main( String args[] )
	{
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(11);
		list.add(5);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(12345);
		list.add(11);
		System.out.println(ListOddToEven.go(list));
		list.set(0, 2);
		list.set(1, 4);
		list.set(2, 6);
		list.set(3, 8);
		list.set(4, 8);
		list.remove(5);
		list.remove(6);
		list.remove(7);
		list.remove(8);
		list.remove(9);
		System.out.println(ListOddToEven.go(list));
	}
}