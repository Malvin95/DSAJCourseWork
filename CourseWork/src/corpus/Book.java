package corpus;


import java.util.ArrayList;
/**
 * This class models the makeup of a Book.
 * 
 * @author S Saddique, M Harding, J Arogundade
 * @version 08/12/2016
 *
 */

public class Book<T> {
	private String title;
	private ArrayList<T> subSections;
	private String author;
	
	/**
	 * The book constructor which initialises; the title, 
	 * subSections ArrayList and Author name of any given book.
	 * 
	 * @param bookTitle is the processed name of any given book.
	 * @param authorName is the author name of any given book.
	 */
	public Book(String bookTitle, String authorName) 
	{
		title = bookTitle;
		subSections = new ArrayList<T>();
		author = authorName;
	}
	
	/**
	 * Adds either a chapter or volume to the subSections ArrayList.
	 * @param t is the object that you are looking for within the Array. 
	 */
	public void add(T t)
	{
		subSections.add(t);
	}
	
	/**
	 * Returns an object within the ArrayList.
	 * @param i is the numeric index value that you want from the Array.
	 * @return ArrayList T at the specified position in the subSections.
	 */
	public T get(int i) 
	{
		return subSections.get(i);
	}
	
	/**
	 * @return int of the size of the subSections ArrayList.
	 */
	public int size() {
		return subSections.size();
	}
	
	/**
	 * @return String of the title and the author name of any given book.
	 */
	public String toString() 
	{
		return "The book is called " + title + ". /n The author's name is: " + author + ".";
	}
}
