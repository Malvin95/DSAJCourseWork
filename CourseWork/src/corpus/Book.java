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
	private Author author;
	
	public Book(String bookTitle, String authorName) {
		title = bookTitle;
		subSections = new ArrayList<T>();
		author = new Author(authorName);
	}
	
	public void add(T t){
		subSections.add(t);
	}
	
	// Method which returns an object within the ArrayList.
	public T get() {
		return null;
	}
	
	public String toString() {
		return "The book is called " + title;
	}
}
