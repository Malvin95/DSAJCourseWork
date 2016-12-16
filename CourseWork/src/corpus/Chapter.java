package corpus;

import java.util.ArrayList;

/**
 * This class models the makeup of a Chapter.
 * 
 * @author S Saddique, M Harding, J Arogundade
 * @version 08/12/2016
 *
 */
public class Chapter {
	
	private String ID;
	private ArrayList<Paragraph> paragraphs;
	
	/**
	 * The Constructor initialises the ID of a chapter so that it can be referenced at a later point.
	 * The paragraphs ArrayList is also initialised to hold paragraph objects.
	 * @param ID is the assigned numeric value of any given chapter.
	 */
	public Chapter(String ID) 
	{
		this.ID = ID;
		paragraphs = new ArrayList<Paragraph>();
	}
	
	/**
	 * This method returns the ID of any given chapter.
	 * @return String which is the ID of the chapter searched for.
	 */
	public String getID() {
		return ID;
	}
	
	/** 
	 * This method adds a paragraph object to the ArrayList of paragraphs.
	 * @param para is the variable given to the paragraph object that is being added to the Array.
	 */
	public void add(Paragraph para)
	{
		paragraphs.add(para);
	}
	
	/** 
	 * This method returns a requested paragraph object.
	 * @param i is the index value wanted within the Array.
	 * @return ArrayList paragraphs at the specified index 'i' within the Paragraph object
	 */
	public Paragraph get(int i) {
		return paragraphs.get(i);
	}
	
	/**
	 * @return int which is the size of the paragraph ArrayList.
	 */
	public int size() {
		return paragraphs.size();
	}
	
	/*
	 * A method that iterates through the Paragraphs array and check if 
	 * a Paragraph exists, based on this it returns a boolean.
	 * 
	 * Edit the code so that a searched value will return the wanted Paragraph object
	 
	public boolean Search(int p)
	{
		boolean exists = false;
		
		for(int i = 0; i < paragraphs.size(); i++)
		{
			if(paragraphs.indexOf(i) == p)
			{
				exists = true;
				return exists;
			}
		}
		
		exists = false;
		return exists;
	}
	*/
	
	/**
	 * A method that searches through a chapter.
	 * @param p is the index value of the object wanted.
	 * @return Paragraph object at a specified location when looped in the ArrayList. 
	 * 		If the paragraph does not exist, the method returns a null value.
	 */
	public Paragraph SearchPara(int p)
	{		
		for(int i = 0; i < paragraphs.size(); i++)
		{
			if(paragraphs.indexOf(i) == p)
			{
				Paragraph Para = paragraphs.get(i);
				return Para;
			}
		}	
		return null;
	}
}
