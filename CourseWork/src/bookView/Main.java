package bookView;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		MainController mc = new MainController();
		TUI tui = new TUI(mc);
	}

}
