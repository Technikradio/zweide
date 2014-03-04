package zweidemo2;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	int posx = 0, posy = 0, fieldx = 0, fieldy = 0;
	Image player_steady, player_up, player_down, player_left, player_right;

	public Player(int x, int y) {
		fieldx = x;
		fieldy = y;
		posx = 32 * fieldx;
		posy = 32 * fieldy;
		getResources();
	}

	private void getResources() {
		try {
			player_up = ImageIO.read(new File("player_up.png"));
			player_down = ImageIO.read(new File("player_down.png"));
			player_left = ImageIO.read(new File("player_left.png"));
			player_right = ImageIO.read(new File("player_right.png"));
			player_steady = ImageIO.read(new File("player_steady.png"));
		} catch (IOException e) {
			System.err.println("ImageFile not found: " + e.getMessage());
			System.exit(1);
		}
	}

	boolean slide(final int x, final int y, final GamePanel board) {

		int movelength = 0;
		for (int i = 0;; i++) {
			if (fieldx + i * x < 0 || fieldx + i * x >= board.fields.length
					|| fieldy + i * y < 0
					|| fieldy + i * y >= board.fields[fieldx].length
					|| !board.fields[fieldx + i * x][fieldy + i * y].isPassable) {
				movelength = i - 1;
				break;
			}
		}
		if (movelength < 1)
			return false;

		if (x > 0)
			board.currentPlayerTexture = player_right;
		if (x < 0)
			board.currentPlayerTexture = player_left;
		if (y > 0)
			board.currentPlayerTexture = player_down;
		if (y < 0)
			board.currentPlayerTexture = player_up;

		fieldx += movelength * x;
		fieldy += movelength * y;

		while (fieldx * 32 != posx || fieldy * 32 != posy) {
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			posx += x;
			posy += y;
			board.paintImmediately(posx, posy, 32, 32);
			for (int i = 0; i < 5; i++) {
				if (board.targets[i].x * 32 == posx
						&& board.targets[i].y * 32 == posy) {
					board.nextLevel();
					return true;
				}
			}
		}
		board.currentPlayerTexture = player_steady;
		board.paintImmediately(0, 0, board.fields.length * 32,
				board.fields[0].length * 32);
		return true;
	}

}
