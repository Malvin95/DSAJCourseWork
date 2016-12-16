package bookView;
import corpus.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainController implements Controller{
	
	private ArrayList<TextReader> texts;
	private TextReader text1;
	private TextReader text2;
	private TextReader text3;
	
	public MainController() throws IOException {
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
	
	@Override
	public String getKWIC(String word) 
	{
		int idCount = 0;
		String wordID = "ID  " + idCount + ":";
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
								if (wor.match(word) == true) {
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
			} else {
				Book<Chapter> book = text.getChapterBook();
				for(int c = 0; c < book.size(); c++) {
					Chapter chap = book.get(c);
					for(int n = 0; n < chap.size(); n++) {
						Paragraph para = chap.get(n);
						for(int x = 0; x < para.size(); x++) {
							Word wor = para.get(x);
							if (wor.match(word) == true) {
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

	@Override
	public String getKWIC(String word, int contextSize) 
	{
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
								if (wor.match(word) == true) {
									//TODO
									// WORD HAS MATCHED WITH SEARCH:
									// WE MUST ATTACH AN ID TO EACH WORD, AND DISPLAY
									// contextSize AMOUNT OF WORDS EACH SIDE OF IT
								}
							}
						}
					}
				}
			} else {
				Book<Chapter> book = text.getChapterBook();
				for(int c = 0; c < book.size(); c++) {
					Chapter chap = book.get(c);
					for(int n = 0; n < chap.size(); n++) {
						Paragraph para = chap.get(n);
						for(int x = 0; x < para.size(); x++) {
							Word wor = para.get(x);
							if (wor.match(word) == true) {
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

	@Override
	public String getWiderContext(String kwicID) {
		// 1: Get a string id which is related to a word
		// 2: Need to search for the word in a paragraph to get the paragraph no.
		// 3: Need to search for the paragraph in the chapter to get the chapter number
		// 4a: If there are volumes - Search for the chapter in the volume to get the chapter number
		// 4b: If there are no volumes - Search for the chapter in the book to get the chapter number
		// 4aa: If there are volumes - Search for the volume in the book to get the volume number
		// 6: Get the book info - Title and Author
		// 7: Display the info out as a string
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
								if (wor.match(kwicID) == true) {
									sb.append("Word " + wor.getWord() + " is found in: /n");
									sb.append(book.toString() + "/n");
									sb.append("Volume number: " + (c + 1) + "/n");
									sb.append("Chapter number: " + (v + 1) +  "/n");
									sb.append("Paragraph number: " + (n + 1) + "/n");
								}
							}
						}
					}
				}
			} else {
				Book<Chapter> book = text.getChapterBook();
				for(int c = 0; c < book.size(); c++) {
					Chapter chap = book.get(c);
					for(int n = 0; n < chap.size(); n++) {
						Paragraph para = chap.get(n);
						for(int x = 0; x < para.size(); x++) {
							Word wor = para.get(x);
							if (wor.match(kwicID) == true) {
								sb.append("Word " + wor.getWord() + " is found in: /n");
								sb.append(book.toString() + "/n");
								sb.append("Chapter number: " + (c + 1) + "/n");
								sb.append("Paragraph number: " + (n + 1) + "/n");
							} 
						}
					}
				}
			}
		}
		return sb.toString();
	}
}

//text1.getChapterBook().get().get().everyAppearance();
