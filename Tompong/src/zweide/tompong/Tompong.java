package zweide.tompong;


public class Tompong {

	static GameFrame frame;
	static Menu menu;

	public static void main(String[] args) {
		frame = new GameFrame();
		menu = new Menu();
		menu.setVisible(true);
	}
	
	public static void menu_OnEasyClick(){
		Resources.levelIndex = 0;
		menu.setVisible(false);
		frame.setVisible(true);
	}
	
	public static void menu_OnMediumClick(){
		Recources.levelIndex = 1;
		menu.setVisible(false);
		frame.setVisible(true);
	}

	public static void menu_OnHardClick(){
		Recources.levelIndex = 2;
		menu.setVisible(false);
		frame.setVisible(true);
	}
	
	public static void menu_OnCostumClick(){
		//TODO implement costum menu
		menu.setVisible(false);
		frame.setVisible(true);
	}
}
