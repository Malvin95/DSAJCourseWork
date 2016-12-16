package corpus;

import java.util.ArrayList;
/**
 * This class models the makeup of a Volume.
 * 
 * @author S Saddique, M Harding, J Arogundade
 * @version 08/12/2016
 *
 */

public class Volume {
	
	private String ID;
	private ArrayList<Chapter> chapters;
	
	/**
	 * The Constructor initialises the ID of a Volume so that it can be referenced at a later point.
	 * The chapters ArrayList is also initialised to hold paragraph objects.
	 * @param ID is the given ID to any volume. 
	 */
	public Volume(String ID) 
	{
		this.ID = ID;
		chapters = new ArrayList<Chapter>();
	}
	
	/**
	 * @return returns the ID of any given Volume.
	 */
	public String getID() {
		return ID;
	}
	
	/** 
	 *A method that adds a chapter to the chapters ArrayList.
	 *  @param ch is the variable assigned to a chapter object to then add it to the chapters ArrayList. 
	 */
	public void add(Chapter ch)
	{
		chapters.add(ch);
	}
	
	/** 
	 * A method that searches through the chapters ArrayList and returns the desired chapter. 
	 * @param i is the index value of the chapter requested.
	 * @return int is the number of the chapter requested.
	 */
	public Chapter get(int i)
	{
		return chapters.get(i);
	}
	
	/**
	 * @return int which is the amount of all the items within the chapters ArrayList
	 */
	public int size() 
	{
		return chapters.size();
	}
	
	/** 
	 * A method that iterates through the Paragraphs ArrayList and checks if a paragraph exists. 
	 * @param p is the index value used to search through the chapters ArrayList.
	 * @return Chapter at the position (p) requested otherwise returns a null object.
	 */
	public Chapter Search(int p)
	{
		for(int i = 0; i < chapters.size(); i++)
		{
			if(chapters.indexOf(i) == p)
			{
				Chapter chapter = chapters.get(i);
				return chapter;
			}
		}
		return null;
	}	
}
