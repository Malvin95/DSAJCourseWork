package corpus;

import java.util.ArrayList;
/**
 * A class which models the makeup of a Volume.
 * 
 * @author S Saddique
 * @version 08/12/2016
 *
 */
public class Volume {
	private ArrayList<Chapter> chapters;
	
	public Volume() {
		chapters = new ArrayList<Chapter>();
	}
	
	public void addChapter(Chapter ch)
	{
		chapters.add(ch);
	}
	
	/*
	 * A method that iterates through the Paragraphs array and check if 
	 * a Paragraph exists, based on this it returns a boolean.
	 */
	public boolean Search(int p)
	{
		boolean exists = false;
		
		for(int i = 0; i < chapters.size(); i++)
		{
			if(chapters.indexOf(i) == p)
			{
				exists = true;
				return exists;
			}
		}
		
		exists = false;
		return exists;
	}
	
	
}
