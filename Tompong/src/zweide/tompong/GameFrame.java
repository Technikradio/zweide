package zweide.tompong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements ActionListener, KeyListener {
	
	private PongPanel pong;
	
	public GameFrame() {
		int x=800;
		int y=600;
		setSize(x, y);
		setTitle("Tompong");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posx = (d.width - x) / 2;
		int posy = (d.height - y) / 2;
		setLocation(posx, posy);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(Color.black);
		
		pong = new PongPanel();
		add(pong);
		
		this.addKeyListener(this);
		
	}

	@Override public void keyTyped(KeyEvent e) { }

	@Override public void keyPressed(KeyEvent e) {
		pong.keyInput(e, true);
	}

	@Override public void keyReleased(KeyEvent e) {
		pong.keyInput(e, false);
	}

	@Override
	public void actionPerformed(ActionEvent e) { }
	
	
	
}
