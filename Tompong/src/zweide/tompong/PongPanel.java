package zweide.tompong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PongPanel extends JPanel implements Runnable {

	private Player playerL, playerR;
	private int frameWidth, frameHeight;

	public PongPanel(int x, int y) {

		frameWidth = x;
		frameHeight = y;

		setBackground(Color.black);

		playerL = new Player();
		playerR = new Player();

		playerL.setPosBounds(0, frameHeight - 14);
		playerR.setPosBounds(0, frameHeight - 14);

		playerL.setPos((frameHeight - 28 - playerL.getBarHeight()) / 2);
		playerR.setPos((frameHeight - 28 - playerR.getBarHeight()) / 2);

		playerL.setKEYCODE_UP(37);
		playerL.setKEYCODE_DOWN(39);

		playerR.setKEYCODE_UP(38);
		playerR.setKEYCODE_DOWN(40);

		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			playerR.setPos(playerR.getPos() + 10 * playerR.getMovement());
			playerL.setPos(playerL.getPos() + 10 * playerL.getMovement());
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(7 + 20, playerL.getPos(), 10, 50);
		g.fillRect(frameWidth - 14 - 20 - 10, playerR.getPos(), 10, 50);
	}

	public void keyInput(KeyEvent e, boolean active) {
		if (e.getKeyCode() == playerR.getKEYCODE_UP())
			playerR.setGoingUp(active);
		else if (e.getKeyCode() == playerR.getKEYCODE_DOWN())
			playerR.setGoingDown(active);
		else if (e.getKeyCode() == playerL.getKEYCODE_UP())
			playerL.setGoingUp(active);
		else if (e.getKeyCode() == playerL.getKEYCODE_DOWN())
			playerL.setGoingDown(active);
	}

}
