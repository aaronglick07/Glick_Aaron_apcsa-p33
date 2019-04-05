//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;

    public WordSearch( int size, String str )
    {
    	m = new String[size][size];
    	int cut = 0;
    	for (int x = 0; x < m.length; x++) {
			for (int y = 0; y < m.length; y++) {
				m[x][y] = str.substring(cut, cut + 1);
				cut++;
			}
		}
    }

    public boolean isFound( String word )
    {
    	for (int x = 0; x < m.length; x++) {
			for (int y = 0; y < m[x].length; y++) {
				if(checkRight(word,x,y) == true || checkLeft(word,x,y) == true || 
						checkUp(word,x,y) == true || checkDown(word,x,y) == true ||
						checkDiagUpRight(word,x,y) == true || checkDiagUpLeft(word,x,y) == true ||
						checkDiagDownLeft(word,x,y) == true || checkDiagDownRight(word,x,y) == true){
					return true;
				}
			}
		}
    	return false;
    }

	public boolean checkRight(String w, int r, int c)
   {
		String letters = "";
		if(c + 1 + w.length() > m[r].length);
		else{
			for (int i = 0; i < w.length(); i++) {
				letters += m[r][c+i];
			}
			if(w.compareTo(letters) == 0){
				return true;
			}
		}
		return false;
	}

	public boolean checkLeft(String w, int r, int c)
	{
		String letters = "";
		if(c + 1 - w.length() < 0);
		else{
			for (int i = 0; i < w.length(); i++) {
				letters += m[r][c-i];
			}
			if(w.compareTo(letters) == 0){
				return true;
			}
		}
		return false;
	}

	public boolean checkUp(String w, int r, int c)
	{
		
		String letters = "";
		if(r + 1 - w.length() < 0);
		else{
			for (int i = 0; i < w.length(); i++) {
				letters += m[r-i][c];
			}
			if(w.compareTo(letters) == 0){
				return true;
			}
		}
		return false;
	}

	public boolean checkDown(String w, int r, int c)
   {
		String letters = "";
		if(r + 1 + w.length() > m.length);
		else{
			for (int i = 0; i < w.length(); i++) {
				letters += m[r+i][c];
			}
			if(w.compareTo(letters) == 0){
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		String letters = "";
		if(r+1 - w.length() < 0 || c + 1 + w.length() > m[r].length);
		else{
			for (int i = 0; i < w.length(); i++) {
				letters+=m[r-i][c+i];
			}
			if(w.compareTo(letters) == 0){
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		String letters = "";
		if(r+1 - w.length() < 0 || c + 1 - w.length() < m[r].length);
		else{
			for (int i = 0; i < w.length(); i++) {
				letters+=m[r-i][c-i];
			}
			if(w.compareTo(letters) == 0){
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {
		String letters = "";
		if(r+1 + w.length() > 0 || c + 1 - w.length() <0);
		else{
			for (int i = 0; i < w.length(); i++) {
				letters+=m[r+i][c-i];
			}
			if(w.compareTo(letters) == 0){
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		String letters = "";
		if(r+1 + w.length() > m.length || c + 1 + w.length() > m[r].length);
		else{
			for (int i = 0; i < w.length(); i++) {
				letters+=m[r+i][c+i];
			}
			if(w.compareTo(letters) == 0){
				return true;
			}
		}
		return false;
	}

    public String toString()
    {
 		return "";
    }
}
