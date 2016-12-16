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
	//private boolean paragraphLineBreak;
	private boolean bookExists = false;
	private Book<Volume> bookVolume;
	private Book<Chapter> bookChapter;
	private Volume currentVolume;
	private Chapter currentChapter;
	private Paragraph currentParagraph = null;
	StringBuilder paragraphText = new StringBuilder();

	public TextReader(String filename) {

		try{
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String currentLine = br.readLine();
			while (currentLine != null) {
				processLine(currentLine);    
				currentLine = br.readLine();
			}
			//System.out.print("file read");
		} catch(Exception e){
			e.printStackTrace();

		}
	}

	private void processLine(String str) {
		// 1: Take in the text file
		// 2: Process it line by line
		// 3: If line contains "Title: [book name]", That needs to be set to the book title
		// 4: If line contains "Author: [author name]", that needs to be set to the author's name
		// 5: If line contains "Volume [roman numeral]", the book needs to take in volumes, and a volume needs to be created to be put in the book. The book does not take in chapters (can be done with a boolean check)
		// 6: If line contains "Chapter [number/roman numeral]", If no volumes already then goes in book. otherwise it goes in volume.
		// 7: If line contains none of the above and it contains words, it is a paragraph. Create a paragraph object and put it in chapter.
		// 8: If another line of text, add it into a stringbuilder for the paragraph object.
		// 9: If a line break, this signals the end of the paragraph.
		
		if (str.contains("Title: ") == true) {
			processBookTitle(str);
		} else if (str.contains("Author: ") == true) {
			processBookAuthor(str);
		}   else if (str.contains("VOLUME ") == true) {
			processVolume(str);
		} else if (str.contains("CHAPTER ") == true) {
			processChapter(str);
		} else {
			processParagraph(str);
		}
	}

	public Book<Volume> getVolumeBook() {
		return bookVolume;
	}

	public Book<Chapter> getChapterBook() {
		return bookChapter;
	}

	public boolean getHasVolume() {
		return hasVolume;
	}

	private void processBookTitle(String str) {
		String[] result = str.split("\\s");
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < result.length; i++) {
			sb.append(result[i]);
			sb.append(" ");
		}
		bookTitle = sb.toString();	
	}
	
	private void processBookAuthor(String str) {
		String[] result = str.split("\\s");
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < result.length; i++) {
			sb.append(result[i]);
			sb.append(" ");
		}
		authorName = sb.toString();
	}
	
	private void processVolume(String str) {
		hasVolume = true;
		if (hasVolume && !bookExists) {
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
		currentVolume = new Volume(volID);
		bookVolume.add(currentVolume);
	}
	
	private void processChapter(String str) {
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
		currentChapter = new Chapter(chapID); 
		if (hasVolume == true) {
			currentVolume.add(currentChapter);
		} else {
			bookChapter.add(currentChapter);
		}
	}	

	private void processParagraph(String str) {
		// lines can either have text or not at this point
		// if lines have text, we need to save that text until it becomes blank again
		// when it becomes blank again, whatever we have in our text becomes the paragraph
		if (!(str.isEmpty())) {
			paragraphText.append(str);
			paragraphText.append(" ");
		} else {
			if (paragraphText.length() > 0) {
				currentParagraph = new Paragraph();
				currentParagraph.add(paragraphText.toString());
				currentChapter.add(currentParagraph);
				paragraphText.setLength(0);
			}
		}
	}
}
