package zweide.tompong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PongPanel extends JPanel implements Runnable {

	private Player playerL, playerR;
	private Ball mainBall;
	private int frameWidth, frameHeight;
	private Level currentLevel;

	public PongPanel(int x, int y) {

		frameWidth = x;
		frameHeight = y;

		setBackground(Color.black);

		playerL = new Player();
		playerR = new Player();
		mainBall = new Ball(16, frameWidth / 2 - 8, frameHeight / 2 - 8);

		playerL.setPosBounds(0, frameHeight - 28);
		playerR.setPosBounds(0, frameHeight - 28);
		mainBall.setPosBounds(0, frameHeight - 28);

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

		// initialize
		long startTime, elapsedTime;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		if (Math.random() >= 0.5)
			mainBall.setVerticalMotion(1);
		else
			mainBall.setVerticalMotion(-1);
		if (Math.random() >= 0.5)
			mainBall.setHorizontalDirection(1);
		else
			mainBall.setHorizontalDirection(-1);

		// wait
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		System.out.println("Entering Gameloop");

		while (true) {

			// Get Calculation start timing
			startTime = System.currentTimeMillis();

			// Player
			playerR.setPos(playerR.getPos() + currentLevel.barSpeed
					* playerR.getMovement());
			playerL.setPos(playerL.getPos() + currentLevel.barSpeed
					* playerL.getMovement());

			// MainBall
			mainBall.setHoriPos(mainBall.getHoriPos()
					+ mainBall.getHorizontalDirection()
					* mainBall.getHorizontalDistance());
			mainBall.setVertPos(mainBall.getVertPos()
					+ mainBall.getVerticalMotion());

			// Repaint
			repaint();

			// Calculate elapsed time
			elapsedTime = System.currentTimeMillis() - startTime;
			if (elapsedTime > 1) {
				System.out.println("Frame Time high: " + elapsedTime
						+ " Time: " + sdf.format(new Date()));
			}

			// Wait
			try {
				Thread.sleep(20 - elapsedTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {

		// General
		super.paintComponent(g);
		g.setColor(Color.white);

		// Player
		g.fillRect(7 + 20, playerL.getPos(), 10, playerL.getBarHeight());
		g.fillRect(frameWidth - 37, playerR.getPos(), 10,
				playerR.getBarHeight());

		// Ball
		g.fillRect(mainBall.getHoriPos(), mainBall.getVertPos(),
				mainBall.getSize(), mainBall.getSize());

	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level newLevel) {
		currentLevel = newLevel;
		playerL.setBarHeight(currentLevel.barHeight);
		playerR.setBarHeight(currentLevel.barHeight);
		mainBall.setSpeed(currentLevel.ballSpeed);
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
