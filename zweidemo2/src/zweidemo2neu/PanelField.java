package zweidemo2neu;

import java.awt.Image;

public class PanelField {
	boolean isPassable = false;
	Image texture = null;
	int x = 0, y = 0;

	PanelField(int posx, int posy, boolean passable, Image image) {
		x = posx;
		y = posy;
		isPassable = passable;
		texture = image;
	}
}
