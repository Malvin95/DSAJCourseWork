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
	
	/**
	 * The constructor which initialises the Word object with a
	 * String value ID and a String Value word.
	 */
	public Word() 
	{
		ID = "";
		word = "";
	}
	
	/**
	 * The second constructor.
	 * @param word is taken in and is stored as the 
	 * String word variable the Word object.
	 */
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
	
	/**
	 * This method sets the word to any given word.
	 * @param word is the user specified variable that is passed in 
	 * 		and set as the Word objects String word Variable.
	 */
	public void setWord(String word) 
	{
		this.word = word;
	}
	
	/**
	 * This method returns the stored word String that that word object is holding.
	 * @return String is the word that the object is holding.
	 */
	public String getWord()
	{
		return word; 
	}
	
	/**
	 * This method sets the ID of the word object to whatever the user has specified.
	 * @param ID The variable that the user wants the word to be set to.
	 */
	public void setID(String ID) 
	{
		this.ID = ID;
	}
	
	/**
	 * This method returns the ID of the word object.
	 * @return String The ID value that the word object is holding.
	 */
	public String getID() 
	{
		return ID;
	}
	
	/**
	 * This method uses a boolean and checks whether the word that the user 
	 * wishes to find matches with the word value that the word object is holding.
	 * @param word is the desired word that the user wishes to find.
	 * @return boolean returns either a true or false value based on whether the values match.
	 */
	public boolean matchWord(String word) 
	{
		if (this.word.toLowerCase().contains(word.toLowerCase())) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	/**
	 * This method uses a boolean and checks whether the ID that the user 
	 * wishes to find matches with the ID value that the word object is holding.
	 * @param kwicID is the desired ID that the user wishes to find.
	 * @return boolean returns either a true or false value based on whether the values match.
	 */
	public boolean matchID(String kwicID) 
	{
		if (kwicID == ID) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
