//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	public int compareTo( Word rhs )
	{		
		return Integer.compare(this.toString().length(), rhs.toString().length());
	}

	public String toString()
	{
		return word;
	}
}