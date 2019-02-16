//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;


public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		
		
		LetterRemover remove = new LetterRemover();
		remove.setRemover("I am Sam I am", 'a');
		System.out.println(remove);
		
		remove.setRemover("ssssssssssssssssssssssssssssss", 's');
		System.out.println(remove);
									
		remove.setRemover("qwertyqwertyqwerty", 'a');
		System.out.println(remove);
		
		remove.setRemover("ababababababababa", 'b');
		System.out.println(remove);
		
		remove.setRemover("abababababababa", 'x');
		System.out.println(remove);
	}
}