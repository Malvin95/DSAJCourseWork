package corpus;

import java.util.ArrayList;
/**
 * A class which models the makeup of a Chapter.
 * 
 * @author S Saddique, M Harding
 * @version 08/12/2016
 *
 */
public class Chapter {
	
	private ArrayList<Paragraph> paragraphs;
	
	public Chapter() 
	{
		paragraphs = new ArrayList<Paragraph>();
	}
	
	public void addParagraph(Paragraph para)
	{
		paragraphs.add(para);
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
	
	/*
	 * An updated version of the above code that searches through a chapter 
	 * and returns the paragraph at a specified location.
	 * If the paragraph does not exist, the method returns a null value.
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
