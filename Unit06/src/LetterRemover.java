//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		sentence = "";
		lookFor = 'f';
	}

	//add in second constructor
	public LetterRemover(String words, char letter) {
		sentence = words;
		lookFor = letter;
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		int location = sentence.indexOf(lookFor);
		String cleaned=sentence;
		while(cleaned.contains(lookFor + "")) {
			cleaned.substring(location);
			location = sentence.indexOf(lookFor)
		}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters();
	}
}