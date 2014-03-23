package zweide.tompong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PongPanel extends JPanel implements Runnable{

	private Player ai, player;

	public PongPanel() {
		setBackground(Color.black);

		ai = new Player();
		player = new Player();

		player.setKEYCODE_UP(38);
		player.setKEYCODE_DOWN(40);

		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(true) {
			player.setPos(player.getPos()+10*player.getMovement());
			paintImmediately(0, 0, 800, 600);
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
		g.fillRect(20, ai.getPos(), 10, 50);
		g.fillRect(770, player.getPos(), 10, 50);
	}

	public void keyInput(KeyEvent e, boolean active) {
		if (e.getKeyCode() == player.getKEYCODE_UP())
			player.setGoingUp(active);
		else if (e.getKeyCode() == player.getKEYCODE_DOWN())
			player.setGoingDown(active);
	}

}
