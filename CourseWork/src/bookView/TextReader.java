package bookView;

import java.io.BufferedReader;
import java.io.FileReader;
import corpus.*;

/**
* A class to take in text files, and sort them out 
* amongst the custom collections we have created.
* 
* @author S Saddique, M Harding
* @version 08/12/2016
*
*/
public class TextReader {
	// Need something to read the text
	// We Need to assign the text to objects and assign those objects appropriately
	private BufferedReader br;
	private FileReader fr;
	private String bookTitle;
	private String authorName;
	private boolean hasVolume = false;
	private boolean lineBreak;
	private boolean bookExists = false;
	private Book<Volume> bookVolume;
	private Book<Chapter> bookChapter;
	private Volume currentVolume;
	private Chapter currentChapter;
	private Paragraph currentParagraph;
	
	public TextReader(String filename) {
		// 1: Take in the text file
		// 2: Process it line by line
		// 3: If line contains "Title: [book name]", That needs to be set to the book title
		// 4: If line contains "Author: [author name]", that needs to be set to the author's name
		// 5: If line contains "VOLUME [roman numeral]", the book needs to take in volumes, and a volume needs to be created to be put in the book. The book does not take in chapters (can be done with a boolean check)
		// 6: If line contains "CHAPTER [number/roman numeral]", If no volumes already then goes in book. otherwise it goes in volume.
		// 7: If line contains none of the above and it contains words, it is a paragraph. Create a paragraph object and put it in chapter.
		// 8: If another line of text, add it into a stringbuilder for the paragraph object.
		// 9: If a line break, this signals the end of the paragraph.
		
		fr = new FileReader(filename);
		br = new BufferedReader(fr);
		String currentLine;
		while ((currentLine = br.readLine()) != null) {
			processLine(currentLine);    
			// creation of book and its components - happens within processLine
		}
	}
	
	private void processLine(String str) {
		//DONE 1: Take in the text file
		//DONE 2: Process it line by line
		//DONE 3: If line contains "Title: [book name]", That needs to be set to the book title
		//DONE 4: If line contains "Author: [author name]", that needs to be set to the author's name
		// 5: If line contains "Volume [roman numeral]", the book needs to take in volumes, and a volume needs to be created to be put in the book. The book does not take in chapters (can be done with a boolean check)
		// 6: If line contains "Chapter [number/roman numeral]", If no volumes already then goes in book. otherwise it goes in volume.
		// 7: If line contains none of the above and it contains words, it is a paragraph. Create a paragraph object and put it in chapter.
		// 8: If another line of text, add it into a stringbuilder for the paragraph object.
		// 9: If a line break, this signals the end of the paragraph.
		StringBuilder paragraphText = new StringBuilder();
		
		if (str.contains("Title: ") == true) {
			String[] result = str.split("\\s");
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < result.length; i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			bookTitle = sb.toString();
		} else if (str.contains("Author: ") == true) {
			String[] result = str.split("\\s");
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < result.length; i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			authorName = sb.toString();
		}   else if (str.contains("VOLUME ") == true) {
			hasVolume = true;
			if (hasVolume == true && bookExists == false) {
				bookVolume = new Book<Volume>(bookTitle, authorName);
				bookExists = true;
			}
			String[] result = str.split("\\s");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			String volID = sb.toString();
			currentVolume = new Volume(volID); //FIXME Volume needs a new constructor and field for id
			bookVolume.add(currentVolume);
		} else if (str.contains("CHAPTER ") == true) {
			if (hasVolume == false && bookExists == false) {
				bookChapter = new Book<Chapter>(bookTitle, authorName);
				bookExists = true;
			}
			String[] result = str.split("\\s");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			String chapID = sb.toString();
			currentChapter = new Chapter(chapID); //FIXME Chapter needs a new constructor and field for id
			if (hasVolume == true) {
				currentVolume.add(currentChapter);
			} else {
				bookChapter.add(currentChapter);
			}
		} else if (!str.isEmpty()) {
			// Create StringBuilder holding this text, appending every line
			String[] result = str.split("\\s");
			for (int i = 0; i < result.length; i++) {
				paragraphText.append(result[i]);
				paragraphText.append(" ");
			}
			lineBreak = false;
		} else if (str.isEmpty()) {
			// Create paragraph with the StringBuilder.toString() text
			String para = paragraphText.toString();
			currentParagraph = new Paragraph(para); //FIXME Needs new constructor to accomodate for this, or a method within paragraph to add the paragraph as an array of strings within it?
			currentChapter.add(currentParagraph);
			lineBreak = true;
		} else {
			//ERROR: Nothing here
		}

		if (lineBreak == true) {
			paragraphText.setLength(0);
		}
	}
}