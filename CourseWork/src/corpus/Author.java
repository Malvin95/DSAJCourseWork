package corpus;

/**
 * A class which models the Author of a Book.
 * 
 * @author S Saddique
 * @version 08/12/2016
 *
 */
public class Author {
	private String name;
	
	public Author(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "The author is " + name;
	}
}
