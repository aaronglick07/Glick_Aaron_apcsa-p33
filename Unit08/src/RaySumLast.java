//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	public static int go(int[] ray)
	{
		int total = 0;
		int check = ray[ray.length-1];
		for (int i = 0; i < ray.length-1; i++) {
			if(ray[i] > check) {
				total += ray[i];
			}
		}
		if(total == 0) return -1;
		return total;
	}
}