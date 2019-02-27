//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int oddCount = -1;
		int evenCount = -1;
		boolean isOdd = false;
		for (int i = 0; i < ray.length-1; i++) {
			if(ray[i] % 2 == 1 && oddCount < 0){
				oddCount = i;
				isOdd = true;
			}
			if(ray[i] % 2 ==0 && evenCount <0 && isOdd){
				evenCount = i;
			}
		}
		if(oddCount == -1 || evenCount == -1) return -1;
		return Math.abs(evenCount - oddCount);
		
	}
}