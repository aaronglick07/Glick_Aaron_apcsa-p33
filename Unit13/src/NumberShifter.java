//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] ray = new int[size];
		int range = 10;
		for (int i = 0; i < ray.length; i++) {
			ray[i] = (int)(range * Math.random());
		}
		shiftEm(ray);
		return ray;
	}
	public static void shiftEm(int[] array)
	{
		int shift = 0;
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == 7){
				temp = array[i];
				array[i] = array[shift];
				array[shift] = temp;
				shift++;
			}
		}
	}
}