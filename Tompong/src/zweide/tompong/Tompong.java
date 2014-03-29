package zweide.tompong;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Tompong {

	static GameFrame gameframe;
	static Menu menu;

	public static void main(String[] args) {
		
		//Debug
		/*
		{
			System.out.println("Debug");
			menu = new Menu();
			menu.setVisible(true);
		}
		//*/
		
		System.out.println("Start");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			System.err.println("Error while changeing System Look and Feel!");
			e.printStackTrace();
		}

		gameframe = new GameFrame();
		gameframe.setVisible(true);
		System.out.println("Setup done");

	}
}
