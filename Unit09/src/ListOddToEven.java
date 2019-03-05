//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		int even = -1;
		int odd = -1;
		boolean isOdd = false;
		int lastEven = 0;
		for (int i = 0; i < ray.size()-1; i++) {
			if(ray.get(i) % 2 == 0) {
				lastEven = ray.get(i);
			}
		}
		for (int i = 0; i < ray.size(); i++) {
			
			if(odd < 0&& ray.get(i) % 2 ==1 && isOdd == false) {
				odd = i;
				isOdd = true;
			}
			if(even < lastEven && ray.get(i) % 2 == 0 && isOdd == true ) {
				even = i;
				even--;
				
				
			}
		}
		if(even == -1 || odd == -1) return -1;
		return Math.abs(odd-even);
	}
}