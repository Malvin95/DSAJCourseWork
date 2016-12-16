package bookView;
import corpus.*;
import java.util.ArrayList;

/**
 * A class that implements the methods of the Controller Interface.
 * 
 * @author S Shaddique, M Harding, J Arogundade
 *
 */
public class MainController implements Controller{
	
	private ArrayList<TextReader> texts;
	private TextReader text1;
	private TextReader text2;
	private TextReader text3;
	int idCount;
	String wordID = "ID  " + idCount + ": ";
	
	/**
	 * The Constructor initialises given text files in a TextReader which 
	 * would extract data that the files would store.
	 */
	public MainController(){
		text1 = new TextReader("data/emmaEd11.txt");
		text2 = new TextReader("data/mansfieldParkEd10.txt");
		text3 = new TextReader("data/pandpEd12.txt");
		initaliseArray();
	}
	
	private void initaliseArray() {
		texts = new ArrayList<TextReader>();
		texts.add(text1);
		texts.add(text2);
		texts.add(text3);
	}
	
	/**
	 * A method that overrides the getKWIC within the Controller interface. 
	 * The method allows a user to search for a given word and would iterate 
	 * through the given files and returns an unspecified number of lines.
	 * This method implements the printKWIC method within the Paragraph 
	 * class to return a view of however many lines that the searched word appears 
	 * within the library of data.
	 * @param word the desired word that the user wishes to find.
	 * @return String a number of lines in which the searched word appears.  
	 */
	@Override
	public String getKWIC(String word) 
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < texts.size(); i++) 
		{
			TextReader text = texts.get(0);
			if (text.getHasVolume()) 
			{
				Book<Volume> book = text.getVolumeBook();
				for(int c = 0; c < book.size(); c++) 
				{
					Volume vol = book.get(c);
					for(int v = 0; v < vol.size(); v++) 
					{
						Chapter chap = vol.get(v);
						for(int n = 0; n < chap.size(); n++) 
						{
							Paragraph para = chap.get(n);
							for(int x = 0; x < para.size(); x++) 
							{
								Word wor = para.get(x);
								if (wor.matchWord(word)) 
								{
									//Word w = wor;
									//w.setID(wordID);
									//idCount++;
									sb.append(para.printKWIC(wor, 10)); // This will print the word in context, with 10 words either side
									//TODO
									// WORD HAS MATCHED WITH SEARCH:
									// wor.setID(wordID);
									// idCount++;
									// WE MUST ATTACH AN ID TO EACH WORD, AND DISPLAY
									// 10 WORDS EACH SIDE OF IT
								}
							}
						}
					}
				}
			} 
			
			else 
			
			{
				Book<Chapter> book = text.getChapterBook();
				for(int c = 0; c < book.size(); c++) 
				{
					Chapter chap = book.get(c);
					for(int n = 0; n < chap.size(); n++) 
					{
						Paragraph para = chap.get(n);
						for(int x = 0; x < para.size(); x++) 
						{
							Word wor = para.get(x);
							if (wor.matchWord(word) == true) 
							{
								Word w = wor;
								w.setID(wordID);
								idCount++;
								sb.append(para.printKWIC(wor, 10)); // This will print the word in context, with 10 words either side
								//TODO
								// WORD HAS MATCHED WITH SEARCH:
								// WE MUST ATTACH AN ID TO EACH WORD, AND DISPLAY
								// 10 WORDS EACH SIDE OF IT
							} 
						}
					}
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * A method that overrides the getKWIC within the Controller interface. 
	 * The method allows a user to search for a given word and would iterate 
	 * through the given files and returns an unspecified number of lines.
	 * This method implements the printKWIC method within the Paragraph class 
	 * to return a view of however many lines that the searched word appears 
	 * within the library of data.
	 * @param word the desired word that the user wishes to find.
	 * @param contextSize the amount of words to left and right of the desired word 
	 * 		that the user wishes to find.
	 * @return String a number of lines in which the searched word appears.  
	 */
	@Override
	public String getKWIC(String word, int contextSize) 
	{
		int idCount = 1;
		String wordID = "ID  " + idCount + ": ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < texts.size(); i++) {
			TextReader text = texts.get(i);
			if (text.getHasVolume() == true) {
				Book<Volume> book = text.getVolumeBook();
				for(int c = 0; c < book.size(); c++) {
					Volume vol = book.get(c);
					for(int v = 0; v < vol.size(); v++) {
						Chapter chap = vol.get(v);
						for(int n = 0; n < chap.size(); n++) {
							Paragraph para = chap.get(n);
							for(int x = 0; x < para.size(); x++) {
								Word wor = para.get(x);
								if (wor.matchWord(word) == true) {
									Word w = wor;
									w.setID(wordID);
									idCount++;
									sb.append(para.printKWIC(wor, contextSize)); // This will print the word in context, with 10 words either side
									//TODO
									// WORD HAS MATCHED WITH SEARCH:
									// WE MUST ATTACH AN ID TO EACH WORD, AND DISPLAY
									// contextSize AMOUNT OF WORDS EACH SIDE OF IT
								}
							}
						}
					}
				}
			} 
			else 
			{
				Book<Chapter> book = text.getChapterBook();
				for(int c = 0; c < book.size(); c++) 
				{
					Chapter chap = book.get(c);
					for(int n = 0; n < chap.size(); n++) 
					{
						Paragraph para = chap.get(n);
						for(int x = 0; x < para.size(); x++) 
						{
							Word wor = para.get(x);
							if (wor.matchWord(word) == true) 
							{
								Word w = wor;
								w.setID(wordID);
								idCount++;
								sb.append(para.printKWIC(wor, contextSize)); // This will print the word in context, with 10 words either side
								//TODO
								// WORD HAS MATCHED WITH SEARCH:
								// WE MUST ATTACH AN ID TO EACH WORD, AND DISPLAY
								// contextSize AMOUNT OF WORDS EACH SIDE OF IT
							} 
						}
					}
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * A method that overrides the getKWIC within the Controller interface. 
	 * The method allows a user to search for a given ID and would iterate 
	 * through the given files and returns an unspecified number of lines.
	 * This method implements the printKWIC method within the Paragraph class 
	 * to return a view of however many lines that the searched word appears 
	 * within the library of data.
	 * @param word the desired word that the user wishes to find.
	 * @param contextSize the amount of words to left and right of the desired word 
	 * 		that the user wishes to find.
	 * @return String a number of lines in which the searched word appears.  
	 */
	@Override
	public String getWiderContext(String kwicID) {
		// 1: Get a string id which is related to a word
		// 2: Need to search for the word in a paragraph to get the paragraph no.
		// 3: Need to search for the paragraph in the chapter to get the chapter number
		// 4a: If there are volumes - Search for the chapter in the volume to get the chapter number.
		// 4b: If there are no volumes - Search for the chapter in the book to get the chapter number.
		// 4aa: If there are volumes - Search for the volume in the book to get the volume number.
		// 6: Get the book info - Title and Author.
		// 7: Display the info out as a string.
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < texts.size(); i++) 
		{
			TextReader text = texts.get(i);
			if (text.getHasVolume() == true) 
			{
				Book<Volume> book = text.getVolumeBook();
				for(int c = 0; c < book.size(); c++) 
				{
					Volume vol = book.get(c);
					for(int v = 0; v < vol.size(); v++) 
					{
						Chapter chap = vol.get(v);
						for(int n = 0; n < chap.size(); n++) 
						{
							Paragraph para = chap.get(n);
							for(int x = 0; x < para.size(); x++) 
							{
								Word wor = para.get(x);
								if (wor.matchID(kwicID) == true) 
								{
									sb.append("Word " + wor.getWord() + " is found in: /n");
									sb.append(book.toString() + "/n");
									sb.append("Volume number: " + (c + 1) + "/n");
									sb.append("Chapter number: " + (v + 1) +  "/n");
									sb.append("Paragraph number: " + (n + 1) + "/n");
									return sb.toString();
								}
							}
						}
					}
				}
			} 
			else 
			{
				Book<Chapter> book = text.getChapterBook();
				for(int c = 0; c < book.size(); c++) 
				{
					Chapter chap = book.get(c);
					for(int n = 0; n < chap.size(); n++) 
					{
						Paragraph para = chap.get(n);
						for(int x = 0; x < para.size(); x++) 
						{
							Word wor = para.get(x);
							if (wor.matchID(kwicID) == true) 
							{
								sb.append("Word " + wor.getWord() + " is found in: /n");
								sb.append(book.toString() + "/n");
								sb.append("Chapter number: " + (c + 1) + "/n");
								sb.append("Paragraph number: " + (n + 1) + "/n");
								return sb.toString();
							} 
						}
					}
				}
			}
		}
		return null;
	}
}

//text1.getChapterBook().get().get().everyAppearance();
