//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		amount = 0;
	}

	public TriangleFive(char c, int amt)
	{
		letter = c;
		amount = amt;
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output="";
		char OGletter = letter;
		for(int a = 0; a < amount; a++){
			for (int i = amount; i > a; i--) {
				for (int j = 0; j < i; j++) {
					output+=letter;
				}
				output+=" ";
				if(letter == 'Z'){
					letter = 'A';
				}
				else{
					letter++;
				}
			}
			output+="\n";
			letter = OGletter;
			
		}
		return output;
	}
}