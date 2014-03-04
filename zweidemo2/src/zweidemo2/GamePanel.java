package zweidemo2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	PanelField[][] fields;
	Player player=null;
	Image rock, ice;

	GamePanel(int x, int y) {
		fields = new PanelField[x][y];
		getResources();
		makeRandom();
	}
	
	private void makeRandom() {
		for(int i=0; i<fields.length; i++) {
			for(int j=0; j<fields[i].length; j++) {
				if(Math.random()>=0.2) {
					fields[i][j] = new PanelField(32*i, 32*j, true, ice);
				} else {
					fields[i][j] = new PanelField(32*i, 32*j, false, rock);
				}
			}
		}
	}

	private void getResources() {
		ice = new ImageIcon("ice.png").getImage();
		rock = new ImageIcon("rock.png").getImage();
	}

	void addPlayer(Player p) {
		if(player==null)
			player=p;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0; i<fields.length; i++) {
			for(int j=0; j<fields[i].length; j++) {
				g.drawImage(fields[i][j].texture, fields[i][j].x, fields[i][j].y, getParent());
			}
		}
	}

}
