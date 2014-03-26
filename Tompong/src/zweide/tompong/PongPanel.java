package zweide.tompong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PongPanel extends JPanel implements Runnable {

	private Player playerL, playerR;
	private int frameWidth, frameHeight;
	private Level currentLevel;

	public PongPanel(int x, int y) {

		frameWidth = x;
		frameHeight = y;

		setBackground(Color.black);

		playerL = new Player();
		playerR = new Player();

		playerL.setPosBounds(0, frameHeight - 28);
		playerR.setPosBounds(0, frameHeight - 28);

		playerL.setPos((frameHeight - 28 - playerL.getBarHeight()) / 2);
		playerR.setPos((frameHeight - 28 - playerR.getBarHeight()) / 2);

		playerL.setKEYCODE_UP(37);
		playerL.setKEYCODE_DOWN(39);

		playerR.setKEYCODE_UP(38);
		playerR.setKEYCODE_DOWN(40);

		setCurrentLevel(Resources.getDefaultLevel());

		Resources.gameThread = new Thread(this);
		Resources.gameThread.start();
	}

	@Override
	public void run() {
		while (true) {
			
			playerR.setPos(playerR.getPos() + currentLevel.barSpeed
					* playerR.getMovement());
			playerL.setPos(playerL.getPos() + currentLevel.barSpeed
					* playerL.getMovement());
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(7 + 20, playerL.getPos(), 10, playerL.getBarHeight());
		g.fillRect(frameWidth - 37, playerR.getPos(), 10, playerR.getBarHeight());
		
		//coming soon
		g.fillRect(frameWidth/2-8, frameHeight/2-8, 16, 16);
		g.drawString("The Ball: coming soon!", frameWidth/2-64, frameHeight/2+32);
		
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level newLevel) {
		currentLevel = newLevel;
		playerL.setBarHeight(currentLevel.barHeight);
		playerR.setBarHeight(currentLevel.barHeight);
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
