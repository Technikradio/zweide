package zweidemo1;

import javax.swing.JFrame;

public class Playground extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Playground frame = new Playground();
		Board feld = new Board(5, 5);
		frame.add(feld);
		frame.setBounds(100, 50, feld.WIDTH * feld.FLOOR_SIZE, feld.HEIGHT * feld.FLOOR_SIZE);
	}

	Playground() {
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
