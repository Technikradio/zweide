package zweidemo2;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	PanelField[][] fields;
	Player player = null;
	Image rock, ice, player_steady;

	GamePanel(int x, int y) {
		fields = new PanelField[x][y];
		getResources();
		makeRandom();
		repaint();
	}

	private void makeRandom() {
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				if (Math.random() >= 0.2) {
					fields[i][j] = new PanelField(32 * i, 32 * j, true, ice);
				} else {
					fields[i][j] = new PanelField(32 * i, 32 * j, false, rock);
				}
			}
		}
	}

	private void getResources() {
			try {
				rock = ImageIO.read(new File("rock.png"));
				ice = ImageIO.read(new File("ice.png"));
				player_steady = ImageIO.read(new File("player_steady.png"));
			} catch (IOException e) {
				System.err.println("ImageFile not found: " + e.getMessage());
				System.exit(1);
			}
		
	}

	void addPlayer(Player p) {
		if (player == null) {
			player = p;
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
		g.drawImage(player_steady, player.posx, player.posy, getParent());

	}

}
