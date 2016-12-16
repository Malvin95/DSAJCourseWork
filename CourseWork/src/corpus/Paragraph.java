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
	private ArrayList<Word> words;
	
	public Paragraph()
	{
		words = new ArrayList<Word>();
	}
	
	public void add(String paragraph)
	{
		String[] paragraphWords = paragraph.split("\\s");
		for (int i = 0; i < paragraphWords.length; i++) {
			Word w = new Word(paragraphWords[i]);
			words.add(w);
		}
	}
	
	public Word get(int i) {
		return words.get(i);
	}
	
	public int size() {
		return words.size();
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
	
	public String printKWIC(Word word, int contextSize) {
		StringBuilder sb = new StringBuilder();
		sb.append(word.getID());
		for (int i = 0; i < words.size(); i++) {
			Word w = words.get(i);
			if (w.equals(word)) {
				int startNumber = i - contextSize;
				
				if (startNumber < 0) {
					startNumber = 0;
				}
				
				for (int v = startNumber; v < i; v++) {
					sb.append(words.get(v));
					sb.append(" ");
				}
				
				sb.append(words.get(i));
				sb.append(" ");
				
				int endNumber = i + contextSize;
				
				if (endNumber > words.size()) {
					endNumber = words.size();
				}
				
				for (int c = i + 1; c < endNumber; c++) {
					sb.append(words.get(c));
					sb.append(" ");
				}
			}
		}
		sb.append("/n");
		return sb.toString();
	}
	
	/*
	 * A Search function that searches for every appearance of a word object 
	 * and adds it to an array that lists info about said word.
	 * The system would then print out the Index of the word 
	 * as well as the Word itself.
	 */
	
	public void everyAppearance(String s)
	{
		ArrayList<Word> ea = new ArrayList<Word>();
		
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
