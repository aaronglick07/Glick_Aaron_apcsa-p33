//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		number = num;

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = Math.min(a, Math.min(b, c));
		int maxReturn =1;
		for (int i = 1; i < max; i++) {
			if(a% i == 0 && b%i == 0 && c%i ==0) {
				maxReturn = i;
			}
		}


		return maxReturn;
	}

	public String toString()
	{
		String output="";
		for (int a = 1; a < number; a++) {
			for (int b = 1; b < number; b++) {
				for (int c = 1; c < number; c++) {
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
						if(a % 2 == 0 && b % 2 == 1 && c % 2 ==1 || (a % 2 == 1 && b % 2 ==0 && c % 2 ==1)) {
							if(greatestCommonFactor(a,b,c) == 1) {
								if(a < b && b < c) {
									output = output + " " + a + " " + b + " " + c + "\n";
								}
							}
						}
					}
				}
			}
		}





		return output+"\n";
	}
}