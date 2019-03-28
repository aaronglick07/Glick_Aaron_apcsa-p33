//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class TotalRow
{
    public static List<Integer> getRowTotals( int[][] m )
    {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int count =0;
    	for(int[] x : m) {
    		for(int y : x) {
    			count+=y;
    		}
    		list.add(count);
    		count = 0;
    	}
		return list;
    }
}
