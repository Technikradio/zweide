package zweide.tompong;


public class Tompong {

	static GameFrame gameframe;
	static Menu menu;

	public static void main(String[] args) {
		gameframe = new GameFrame();
		gameframe.setVisible(true);
		System.out.println("Setup down.");
	}
	
}
