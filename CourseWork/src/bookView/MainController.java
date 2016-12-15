package bookView;

public class MainController implements Controller{
	
	private TextReader text1;
	private TextReader text2;
	private TextReader text3;
	
	public MainController() {
		text1 = new TextReader(/*path of 1st file*/);
		text2 = new TextReader(/*path of 2nd file*/);
		text3 = new TextReader(/*path of 3rd file*/);
	}
	
	@Override
	public String getKWIC(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKWIC(String word, int contextSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWiderContext(String kwicID) {
		// TODO Auto-generated method stub
		return null;
	}

}
