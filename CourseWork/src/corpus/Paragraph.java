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
		int idCount = 1;
		String wordID = "ID  " + idCount + ": "; 
		StringBuilder sb = new StringBuilder();
		ArrayList<String> str = new ArrayList<String>();
		for (int i = 0; i < words.size(); i++) {
			Word w = words.get(i);
			if (w.getWord().contains(word.getWord())) {
				w.setID(wordID);
				sb.append(word.getID());
				idCount++;
				
				int startNumber = i - contextSize;
				
				if (startNumber < 0) {
					startNumber = 0;
				}
				
				for (int v = startNumber; v < i; v++) {
					sb.append(words.get(v).getWord());
					sb.append(" ");
				}
				
				sb.append(w.getWord());
				sb.append(" ");
				
				int endNumber = i + contextSize + 1;
				
				if (endNumber > words.size()) {
					endNumber = words.size();
				}
				
				for (int c = i + 1; c < endNumber; c++) {
					sb.append(words.get(c).getWord());
					sb.append(" ");
				}
				//sb.append("\n");
				//return sb.toString();
				// if the sb length is > contextSize + 1, split every contextSize + 1 words and 
				// append those to a different sb
			}
		}
		sb.append("\n");
		return sb.toString();
		//return null;
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
