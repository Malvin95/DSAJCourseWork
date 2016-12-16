package corpus;

/**
 * A class which models a Word within the Book.
 * 
 * @author S Saddique, M Harding
 * @version 08/12/2016
 *
 */
public class Word {
	
	private String ID;
	private String word;
	
	public Word() {
		ID = "";
		word = "";
	}
	
	public Word(String word) 
	{
		ID = "";
		this.word = word;
	}
	
	/*
	 * 
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
	 */
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord()
	{
		return word; 
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	
	public boolean matchWord(String word) {
		if (this.word.contains(word)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean matchID(String kwicID) {
		if (kwicID == ID) {
			return true;
		} else {
			return false;
		}
	}
}
