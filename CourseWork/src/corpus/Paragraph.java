package corpus;

import java.util.HashMap;
/**
 * A class which models the makeup of a Paragraph.
 * 
 * @author S Saddique
 * @version 08/12/2016
 *
 */
public class Paragraph {
	private HashMap<String, Word> words;
	
	public Paragraph() {
		words = new HashMap<String, Word>();
	}
}
