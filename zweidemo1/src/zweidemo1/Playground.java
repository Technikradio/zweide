package zweidemo1;

import javax.swing.JFrame;

public class Playground extends JFrame {
	
	public static void main(String[] args) {
		Playground frame = new Playground(32, 32);
	}

	Playground(int width, int height) {
		Board feld = new Board(width, height);
		this.add(feld);
		this.setResizable(false);
		this.setBounds(100, 50, feld.WIDTH * feld.FLOOR_SIZE, feld.HEIGHT * feld.FLOOR_SIZE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
