package corpus;

import java.util.ArrayList;

/**
 * A class which models a Word within the Book.
 * 
 * @author S Saddique
 * @version 08/12/2016
 *
 */
public class Word {
	
	private String word;
	//private ArrayList<String> W;
	String[] W;
	
	public Word(String word) 
	{
		this.word = word;
		W = word.split(" ");
	}

	public int Search(String s)
	{
		int j = 0;
		for(int i = 0; i < W.length; i++)
		{
			if(W[i] == s)
			{
				j++;
			}
		}
		return j;
	}
}