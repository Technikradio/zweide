package zweidemo1;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	final int HEIGHT, WIDTH, IMAGE_SIZE = 16;
	boolean[][] validfloor;
	ImageIcon rockimage, floorimage, playerimage;
	Player player;

	Board(int width, int height) {
		super();
		WIDTH = width;
		HEIGHT = height;
		validfloor = new boolean[WIDTH][HEIGHT];
		makeRandom();
		getResources();
		player = new Player(WIDTH / 2, HEIGHT / 2);
	}

	@Override
	protected void paintComponent(Graphics g) {
		for (int i = 0; i < validfloor.length; i++) {
			for (int j = 0; j < validfloor[i].length; j++) {
				if (player.posx == i && player.posy == j) {
					g.drawImage(playerimage.getImage(), i * IMAGE_SIZE, j
							* IMAGE_SIZE, getParent());
				} else if (validfloor[i][j]) {
					g.drawImage(floorimage.getImage(), i * IMAGE_SIZE, j
							* IMAGE_SIZE, getParent());
				} else {
					g.drawImage(rockimage.getImage(), i * IMAGE_SIZE, j
							* IMAGE_SIZE, getParent());
				}
			}
		}

	}

	private void getResources() {
		floorimage = new ImageIcon("floor.png");
		rockimage = new ImageIcon("rock.png");
		playerimage = new ImageIcon("player.png");
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
