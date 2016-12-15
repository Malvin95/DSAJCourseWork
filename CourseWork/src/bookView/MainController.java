package bookView;
import java.util.ArrayList;

public class MainController implements Controller{
	
	private TextReader text1;
	private TextReader text2;
	private TextReader text3;
	private ArrayList<TextReader> texts;
	
	public MainController() {
		text1 = new TextReader(/*path of 1st file*/);
		text2 = new TextReader(/*path of 2nd file*/);
		text3 = new TextReader(/*path of 3rd file*/);
		texts = new ArrayList<TextReader>();
	}
	
	@Override
	public String getKWIC(String word) 
	{
		if(text1.getHasVolume() == true)
		{
			
		}
			
		return null;
	}

	@Override
	public String getKWIC(String word, int contextSize) 
	{
		
		return null;
	}

	@Override
	public String getWiderContext(String kwicID) {
		// TODO Auto-generated method stub
		return null;
	}

}

//text1.getChapterBook().get().get().everyAppearance();
