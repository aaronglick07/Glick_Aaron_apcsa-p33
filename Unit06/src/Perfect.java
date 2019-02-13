//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;

	//add constructors
   public Perfect() {
	   number = 0;
   }
   public Perfect(int num) {
	   number = num;
   }
	//add a set method
   public void setNum(int num) {
	   number = num;
   }
	public boolean isPerfect()
	{
		int total = 0;
		int i = 1;
		do {
			if(number % i == 0) {
				total +=i;
			}
			i++;
		}while(i < number);
		if(number == total) {
			return true;
		}
		return false;
	}

	//add a toString	
	public String toString() {
		if (isPerfect() == true) {
			return number + " is perfect";
		}
		return number + " is not perfect";
	}
}