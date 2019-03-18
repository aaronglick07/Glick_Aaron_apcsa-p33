//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class Skeleton implements Monster
{

	//add instance variables	
	private int size;
	private String name;
	//add a constructor
	public Skeleton(int s, String n) {
		size =s;
		name = n;
	}
	//add code to implement the Monster interface
	@Override
	public int getHowBig() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isBigger(Monster other) {
		// TODO Auto-generated method stub
		if(size > other.getHowBig()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isSmaller(Monster other) {
		// TODO Auto-generated method stub
		if(size < other.getHowBig()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean namesTheSame(Monster other) {
		// TODO Auto-generated method stub
		if(name.equals(other.getName())) {
			return true;
		}
		return false;
	}
	//add a toString
	public String toString() {
		return "" + getName() + " " + getHowBig();
	}
}