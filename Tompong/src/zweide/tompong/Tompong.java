package zweide.tompong;


public class Tompong {

	static GameFrame gameframe;
	static Menu menu;

	public static void main(String[] args) {
		gameframe = new GameFrame();
		menu = new Menu();
		menu.setVisible(true);
	}
	
	public static void menu_OnEasyClick(){
		Resources.levelIndex = 0;
		menu.setVisible(false);
		gameframe.setVisible(true);
	}
	
	public static void menu_OnMediumClick(){
		Resources.levelIndex = 1;
		menu.setVisible(false);
		gameframe.setVisible(true);
	}

	public static void menu_OnHardClick(){
		Resources.levelIndex = 2;
		menu.setVisible(false);
		gameframe.setVisible(true);
	}
	
	public static void menu_OnCostumClick(){
		//TODO implement costum menu
		menu.setVisible(false);
		gameframe.setVisible(true);
	}
}
