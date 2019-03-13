//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int numerator;
	private int denominator;
	//write two constructors
	public Rational(){
		
	}
	public Rational(int num, int dnum){
		numerator = num;
		denominator = dnum;
	}
	//write a setRational method
	public void setRational(int num, int dnum){
		numerator = num;
		denominator = dnum;
	}

	//write  a set method for numerator and denominator
	public void setNumerator(int num){
		num = numerator;
	}
	public void setDemominator(int dnum){
		denominator = dnum;
	}
	
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		numerator = this.getNumerator() * this.getDenominator() + other.getNumerator() * other.getDenominator();
		denominator = this.getDenominator() * other.getDenominator();
		reduce();
	}

	private void reduce()
	{
		if(denominator==0){
			numerator = 0;
			denominator = 0;
		}
		if(denominator < 0){
			numerator = numerator * -1;
			denominator = denominator * -1;
		}
		
		if(numerator < denominator || numerator > denominator){
			for (int i = numerator; i > 1; i--) {
				if(numerator % i == 0 && denominator % i == 0){
					numerator = numerator / i;
					denominator = denominator / i;
				}
			}
		}
	}

	private int gcd(int numOne, int numTwo)
	{

		return numOne*numTwo;
	}

	public Object clone ()
	{
		return new Rational(numerator,denominator);
	}

	//ACCESSORS

	//write get methods for numerator and denominator
	public int getNumerator(){
		return numerator;
	}
	public int getDenominator(){
		return denominator;
	}
	
	public boolean equals( Object obj)
	{
		if(obj.getClass() != this.getClass()){
			return false;
		}
		Rational r = (Rational) obj;
		if(r.getDenominator() == this.getDenominator() && r.getNumerator() == r.getNumerator()){
			return true;
		}
		return false;
	}

	public int compareTo(Rational other)
	{
		double d = (double)numerator/denominator;
		double d2 = (double)other.getNumerator()/other.getDenominator();
		return Double.compare(d, d2);
	}



	
	//write  toString() method
	public String toString(){
		return numerator + "/" + denominator + " ";
	}
	
}