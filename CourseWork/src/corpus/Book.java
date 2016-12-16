package corpus;


import java.util.ArrayList;
/**
 * A class which models the makeup of a Book.
 * 
 * @author S Saddique
 * @version 08/12/2016
 *
 */
public class Book<T> {
	private String title;
	private ArrayList<T> subSections;
	private String author;
	
	public Book(String bookTitle, String authorName) 
	{
		title = bookTitle;
		subSections = new ArrayList<T>();
		author = authorName;
	}
	
	public void add(T t)
	{
		subSections.add(t);
	}
	
	// Method which returns an object within the ArrayList.
	public T get(int i) 
	{
		return subSections.get(i);
	}
	
	public int size() {
		return subSections.size();
	}
	
	public String toString() 
	{
		return "The book is called " + title + ". /n The author's name is: " + author + ".";
	}
}
