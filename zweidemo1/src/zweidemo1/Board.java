package zweidemo1;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel {
	final int HEIGHT, WIDTH, FLOOR_SIZE = 16;
	boolean[][] validfloor;
	ImageIcon rockimage, floorimage;

	Board(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		validfloor = new boolean[WIDTH][HEIGHT];
		this.setLayout(new GridLayout(WIDTH, HEIGHT));
		makeRandom();
		getResources();
		draw();
	}

	private void getResources() {
		floorimage = new ImageIcon( "floor.png" );
		rockimage = new ImageIcon( "rock.png" );
	}

	private void draw() {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (validfloor[i][j]) {
					this.add(new JLabel(floorimage));
				} else {
					this.add(new JLabel(rockimage));
				}
			}
		}
	}

	void makeRandom() {
		for (int i = 0; i < validfloor.length; i++) {
			for (int j = 0; j < validfloor[i].length; j++) {
				if (Math.random() < 0.2)
					validfloor[i][j] = false;
				else
					validfloor[i][j] = true;
			}
		}
		printfloorToConsole(validfloor);
	}

	public int coordinatesToIndex(int x, int y) {
		return x * WIDTH + y;
	}

	private void printfloorToConsole(boolean[][] floor) {
		for (int i = 0; i < floor.length; i++) {
			for (int j = 0; j < floor[i].length; j++) {
				if (floor[i][j])
					System.out.print(".");
				else
					System.out.print("#");
			}
			System.out.println();
		}
	}

}
