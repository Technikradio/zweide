package zweidemo2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	public GameWindow(String title, int x, int y) {
		setSize(32*x+7, 32*y+29);
		setTitle(title);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posx = (d.width - 32*x) / 2;
		int posy = (d.height - 32*y) / 2;
		setLocation(posx, posy);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		int x=16;
		int y=16;
		if(args.length>=2) {
			try {
				x=Integer.parseInt(args[0]);
				y=Integer.parseInt(args[1]);
			} catch(NumberFormatException e) {
				System.err.println(e.getMessage());
			}
		}
		GameWindow frame = new GameWindow("Use WASD or the directional keys to move!", x, y);
		GamePanel board = new GamePanel(x, y);
		frame.add(board);
	}

}
