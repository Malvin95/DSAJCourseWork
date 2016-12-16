package corpus;

import java.util.ArrayList;

/**
 * This class models the makeup of a Paragraph.
 * 
 * @author S Saddique, M Harding, J Arogundade
 * @version 08/12/2016
 *
 */
public class Paragraph {
	
	private ArrayList<Word> words;
	
	/** 
	 * Initialises a paragraph object with an ArrayList of Word objects called words.
	 */
	public Paragraph()
	{
		words = new ArrayList<Word>();
	}
	
	
	/** 
	 * A method that takes in a unspecified length of words, it then splits up the words into individual word 
	 * objects and then adds them to the words ArrayList.
	 * @param paragraph is the variable given to the text file that would then be processed and split up.
	 */
	public void add(String paragraph)
	{
		String[] paragraphWords = paragraph.split("\\s");
		for (int i = 0; i < paragraphWords.length; i++) {
			Word w = new Word(paragraphWords[i]);
			words.add(w);
		}
	}
	
	/**
	 * Gets a word in the words array.
	 * @param i is the index value of the word requested for in the words ArrayList. 
	 * @return Word the word object requested.
	 */
	public Word get(int i) {
		return words.get(i);
	}
	
	/**
	 * This method returns the contents of the Words ArrayList
	 * @return int the numeric value of the contents of the ArrayList. 
	 */
	public int size() {
		return words.size();
	}
	
	/**
	 * A method that checks however many times a word is within the Words ArrayList.
	 * @param s is the string variable given to the word that is searched for.
	 * @return int a numeric value for however many times a word appears.
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
	
	/**
	 * A method that iterates through the words ArrayList in order to find a specified word.
	 * Once it finds the required word it prints the word alongside a amount of words specified 
	 * by the contextSize prior to and after the desired words appearance. 
	 * @param word the word that the user wishes to find.
	 * @param contextSize the amount of words to left and right of the desired word 
	 * 		that the user wishes to find.
	 * @return String is the sentence that is output by the system consisting of the desired word 
	 * 		and the total amount of words specified by the contextSize
	 */
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
	
	/**
	 * A Search function that searches for every appearance of a word object 
	 * and adds it to an array that lists info about said word.
	 * The system would then print out the Index of the word.
	 * as well as the Word itself.
	 * @param s the word to be searched for.
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
