package zweide.tompong;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	public GameFrame() {
		int x=800;
		int y=600;
		setSize(x, y);
		setTitle("Tompong");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posx = (d.width - x) / 2;
		int posy = (d.height - y) / 2;
		setLocation(posx, posy);
		setResizable(false);
		
		PongPanel panel = new PongPanel();
		add(panel);
		
	}
	
	
	
}
