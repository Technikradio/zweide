package zweidemo2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	public GameWindow(String title, int x, int y) {
		setSize(32 * x + 7, 32 * y + 29);
		setTitle(title);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posx = (d.width - 32 * x) / 2;
		int posy = (d.height - 32 * y) / 2;
		setLocation(posx, posy);
		setResizable(false);
	}

	public static void main(String[] args) {
		int x = 16;
		int y = 16;
		if (args.length >= 2) {
			try {
				x = Integer.parseInt(args[0]);
				y = Integer.parseInt(args[1]);
				if (x < 1 || y < 1)
					throw new IllegalArgumentException(
							"Field must be at least 1 by 1");
			} catch (IllegalArgumentException e) {
				System.err.println("Unsupported Argument: " + e.getMessage());
				System.exit(1);
			}
		}
		GameWindow frame = new GameWindow(
				"Use WASD or the directional keys to move!", x, y);
		GamePanel board = new GamePanel(x, y);
		Player player = new Player(x / 2, y / 2);
		board.currentPlayerTexture = player.player_steady;
		board.makeRandom();
		board.addPlayer(player);
		board.makeTargets();
		frame.add(board);
		board.repaint();
		addPlayerSlideListener(frame, board, player);
		frame.setVisible(true);
	}

	private static void addPlayerSlideListener(GameWindow frame,
			final GamePanel board, final Player player) {
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (Math.abs(e.getWhen() - System.currentTimeMillis()) < 100) {
					if (e.getKeyCode() == KeyEvent.VK_UP
							|| Character.toLowerCase(e.getKeyChar()) == 'w') {
						player.slide(0, -1, board);
					} else if (e.getKeyCode() == KeyEvent.VK_LEFT
							|| Character.toLowerCase(e.getKeyChar()) == 'a') {
						player.slide(-1, 0, board);
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN
							|| Character.toLowerCase(e.getKeyChar()) == 's') {
						player.slide(0, 1, board);
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT
							|| Character.toLowerCase(e.getKeyChar()) == 'd') {
						player.slide(1, 0, board);
					} else if (e.getKeyCode() == 17) {
						board.nextLevel();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});
	}

}
