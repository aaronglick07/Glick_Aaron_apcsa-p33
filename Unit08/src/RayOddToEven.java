//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int count = -1;
		int i = -1;
		
		do{
			if(ray[Math.abs(i)] % 2 == 0) {
				
			}
			i++;
			count++;
			
		}while(ray[i] % 2 ==1);
		if(count == 0) return -1;
		return count;
	}
}