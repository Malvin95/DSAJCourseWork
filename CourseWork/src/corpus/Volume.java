package corpus;

import java.util.ArrayList;
/**
 * A class which models the makeup of a Volume.
 * 
 * @author S Saddique, M Harding
 * @version 08/12/2016
 *
 */
public class Volume {
	
	private String ID;
	private ArrayList<Chapter> chapters;
	
	public Volume(String ID) 
	{
		this.ID = ID;
		chapters = new ArrayList<Chapter>();
	}
	
	public String getID() {
		return ID;
	}
	
	public void add(Chapter ch)
	{
		chapters.add(ch);
	}
	
	public Chapter get(int i) {
		return chapters.get(i);
	}
	
	/*
	 * A method that iterates through the Paragraphs array and check if 
	 * a Paragraph exists, based on this it returns a boolean.
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
