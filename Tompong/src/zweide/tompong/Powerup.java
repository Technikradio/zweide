package zweide.tompong;

import java.awt.*;

public abstract class Powerup extends Rectangle {

	private static final long serialVersionUID = 6025508732807590382L;

	public Powerup(int x, int y) {
		super(x,y,32,32);
	}

	public abstract void draw(Graphics g);

	public abstract void onEvent();
}
