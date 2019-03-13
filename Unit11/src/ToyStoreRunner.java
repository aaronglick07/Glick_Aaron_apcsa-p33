//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		ToyStore t = new ToyStore();
		t.loadToys("sorry bat sorry sorry sorry train train teddy teddy ball ball");
		System.out.println(t);
		t.sortToysByCount();
		System.out.println(t);
		System.out.println("Max = " + t.getMostFrequentToy());
	}
}