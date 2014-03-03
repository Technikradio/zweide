package zweidemo2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	public GameWindow(String title, int x, int y) {
		
		
		
		
		setTitle(title);
//		setSize();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posx = (d.width - getSize().width) / 2;
		int posy = (d.height - getSize().height) / 2;
		setLocation(posx, posy);
		
	}

	public static void main(String[] args) {
		GameWindow frame = new GameWindow("Use WASD or the directional keys to move!", 16, 16);
	}

}
