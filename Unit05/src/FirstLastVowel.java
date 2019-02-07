//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
	   if (a.startsWith("a") || a.startsWith("e") || a.startsWith("i") || a.startsWith("o") || a.startsWith("u")) {
		return "yes";
	   }
	   else if (a.startsWith("a", a.length()-1) || a.startsWith("e", a.length()-1) || a.startsWith("i", a.length()-1) || a.startsWith("o", a.length()-1) || a.startsWith("u", a.length()-1)) {
		 return "yes";
	   }
	   if (a.startsWith("A") || a.startsWith("E") || a.startsWith("I") || a.startsWith("O") || a.startsWith("U")) {
			return "yes";
		   }
	   else if (a.startsWith("A", a.length()-1) || a.startsWith("E", a.length()-1) || a.startsWith("I", a.length()-1) || a.startsWith("O", a.length()-1) || a.startsWith("U", a.length()-1)) {
		   return "yes";
	   }
	   return "no";
	}
}