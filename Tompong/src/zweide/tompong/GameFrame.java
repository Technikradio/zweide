package zweide.tompong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener {

	private PongPanel pong;

	public GameFrame() {
		//int x = 800;
		//int y = 600;
		int x = Resources.sizeX;
		int y = Resources.sizeY;
		setSize(x, y);
		setTitle("Tompong" + " :: " + "ATM and FDM use directional keys!");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posx = (d.width - x) / 2;
		int posy = (d.height - y) / 2;
		setLocation(posx, posy);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(Color.black);

		pong = new PongPanel(x, y);
		add(pong);

		this.addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		pong.keyInput(e, true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		pong.keyInput(e, false);
	}

}
