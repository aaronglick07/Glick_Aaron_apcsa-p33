import java.util.Random;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		Random rand = new Random();
		grid = new String[rows][cols];
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				grid[x][y] = vals[rand.nextInt(vals.length)];
			}
		}
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		int max = 0;
		String maxString = "";
		for(String s : vals) {
			max = countVals(s);
			maxString = s;
		}
		return maxString + " occurs the most";
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		int count = 0;
		for(String[] x : grid) {
			for(String y : x) {
				if(y == val) {
					count++;
				}
			}
		}
		return count;
	}

	//display the grid
	public String toString()
	{
		String output="";
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				output+=grid[x][y] + " ";
			}
			output+="\n";
		}
		return output;
	}
}