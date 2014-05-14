package zweidemo2neu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	PanelField[][] fields;
	Player player = null;
	Point[] targets;
	Image rock, ice;
	Image currentPlayerTexture, target;

	GamePanel(int x, int y) {
		fields = new PanelField[x][y];
		targets = new Point[5];
		getResources();
	}

	void makeRandom() {
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				if (Math.random() >= 0.2) {
					fields[i][j] = new PanelField(32 * i, 32 * j, true, ice);
				} else {
					fields[i][j] = new PanelField(32 * i, 32 * j, false, rock);
				}
			}
		}
		if (player != null) {
			fields[player.fieldx][player.fieldy].isPassable = true;
			fields[player.fieldx][player.fieldy].texture = ice;
		}

	}

	private void getResources() {
		try {
			rock = ImageIO.read(new File("rock.png"));
			ice = ImageIO.read(new File("ice.png"));
			target = ImageIO.read(new File("target.png"));
		} catch (IOException e) {
			System.err.println("ImageFile not found: " + e.getMessage());
			System.exit(1);
		}

	}

	void addPlayer(Player p) {
		if (player == null) {
			player = p;
			fields[player.fieldx][player.fieldy] = new PanelField(player.posx,
					player.posy, true, ice);
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				g.drawImage(fields[i][j].texture, fields[i][j].x,
						fields[i][j].y, getParent());
			}
		}
		for (int i = 0; i < targets.length; i++) {
			g.drawImage(target, targets[i].x * 32, targets[i].y * 32,
					getParent());
		}
		g.drawImage(currentPlayerTexture, player.posx, player.posy, getParent());
	}

	void makeTargets() {
		for (int i = 0; i < 5; i++) {
			do {
				targets[i] = new Point();
				targets[i].setLocation((int) (Math.random() * fields.length),
						(int) (Math.random() * fields[0].length));
			} while ((targets[i].x == player.fieldx && targets[i].y == player.fieldy)
					|| !fields[targets[i].x][targets[i].y].isPassable);
		}
	}

	void nextLevel() {
		player.fieldx = player.posx / 32;
		player.fieldy = player.posy / 32;
		makeRandom();
		makeTargets();
		currentPlayerTexture = player.player_steady;
		paintImmediately(0, 0, fields.length * 32, fields[0].length * 32);
	}

}
