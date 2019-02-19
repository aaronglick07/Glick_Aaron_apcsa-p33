//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
	}

	public RockPaperScissors(String player)
	{
		playChoice = player;
	}

	public void setPlayers(String player)
	{
		playChoice = player;
	}

	public String determineWinner()
	{
		int random = (int)(Math.random() * 3);
		switch (random) {
		case 0: compChoice = "R";
			break;
		case 1: compChoice = "P";
			break;
		case 2: compChoice = "S";
		break;
		
		default:
			break;
		}
		String words = "test";
		if(playChoice.equals("R") && compChoice.equals("P")) {
			words = "Paper covers Rock, Computer wins";
		}
		if(playChoice.equals(compChoice)) {
			words = "You and The computer played the same. tie";
		}
		if(playChoice.equals("P") && compChoice.equals("R")) {
			words = "Paper covers Rock, Player wins";
		}
		if(playChoice.equals("P") && compChoice.equals("S")) {
			words = "Scissors cut Paper, Computer wins";
		}
		if(playChoice.equals("S") && compChoice.equals("P")) {
			words = "Scissors cut Paper, Computer wins";
		}
		if(playChoice.equals("R") && compChoice.equals("S")) {
			words = "Rock Destroys Scissors, Player wins";
		}
		if(playChoice.equals("S") && compChoice.equals("R")) {
			words = "Rock Destroys Scissors, Computer wins";
		}
		String winner= words;
		return winner;
	}

	public String toString()
	{
		String output="" + determineWinner();
		return output;
	}
}