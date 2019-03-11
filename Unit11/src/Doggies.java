//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		//point pups at a new arry of Dog
		pups = new Dog[size];
	}
	
	public void set(int spot, int age, String name)
	{
		//put a new Dog in the array at spot 
		Dog d = new Dog(age, name);
		
		//make sure spot is in bounds
		if(spot >= 0 && spot < pups.length) {
			pups[spot] = d;
		}
	}

	public String getNameOfOldest()
	{
		int greatest = pups[0].getAge();
		int greatPup = 0;
		for(int i = 0; i < pups.length; i++) {
			if(greatest < pups[i].getAge()) {
				greatest = pups[i].getAge();
				greatPup++;
			}
		}
		
		return pups[greatPup].getName();
	}

	public String getNameOfYoungest()
	{
		
		int least = pups[0].getAge();
		int leastPup = 0;
		for(int i = 0; i < pups.length; i++) {
			if(least > pups[i].getAge()) {
				least = pups[i].getAge();
				leastPup++;
			}
		}
		
		return pups[leastPup].getName();
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}