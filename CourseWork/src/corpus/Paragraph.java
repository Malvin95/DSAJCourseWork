package corpus;

import java.util.ArrayList;

/**
 * A class which models the makeup of a Paragraph.
 * 
 * @author S Saddique, M Harding
 * @version 08/12/2016
 *
 */

public class Paragraph {
	
	private ArrayList<String> words;
	
	public Paragraph()
	{
		words = new ArrayList<String>();
	}
	
	public void add(String paragraph)
	{
		String[] paragraphWords = paragraph.split("\\s");
		for (int i = 0; i < paragraphWords.length; i++) {
			words.add(paragraphWords[i]);
		}
	}
	
	public String get(int i) {
		return words.get(i);
	}
	
	/*
	 * A search function that tests to see if a word exists within a paragraph
	 */
	
	public int Search(String s)
	{
		int j = 0;
		for(int i = 0; i < words.size(); i++)
		{
			if(s.equals(words.get(i)))
			{
				j++;
			}
		}
		return j;
	}
	
	/*
	 * A Search function that searches for every appearance of a word object 
	 * and adds it to an array that lists info about said word.
	 * The system would then print out the Index of the word 
	 * as well as the Word itself.
	 */
	
	public void everyAppearance(String s)
	{
		ArrayList<String> ea = new ArrayList<String>();
		
		for(int i = 0; i < words.size(); i++)
		{
			if(s.equals(words.get(i)))
			{
				ea.add(words.get(i));
				System.out.println("Word Index:" + i + ea.get(i));
			}
		}
	}
	
}
