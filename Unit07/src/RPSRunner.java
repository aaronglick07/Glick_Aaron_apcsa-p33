//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response;
		
		//add in a do while loop after you get the basics up and running
		String again = "";
		 do {
			String player = "";
		
			out.print("type in your prompt [R,P,S] :: ");
			player = keyboard.nextLine();
			
			//read in the player value
		
			RockPaperScissors game = new RockPaperScissors();	
			System.out.println("Player value is " + player);
			game.setPlayers(player);
			game.determineWinner();
			System.out.println(game);
			System.out.println("Would you like to play again, Y for yes, N for no");
			again = keyboard.nextLine();
		 }
		 while(again.equalsIgnoreCase("y") );
	}
}



