package zweidemo1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Playground extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Playground frame = new Playground();
		final Board feld = new Board(32, 32);
		frame.add(feld);
		frame.setBounds(100, 50, feld.WIDTH * feld.IMAGE_SIZE + 20, feld.HEIGHT
				* feld.IMAGE_SIZE + 40);
		frame.setTitle("Press WASD to move or use the directional keys!");
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP
						|| Character.toLowerCase(e.getKeyChar()) == 'w') {
					feld.player.move(0, -1, feld);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT
						|| Character.toLowerCase(e.getKeyChar()) == 'a') {
					feld.player.move(-1, 0, feld);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN
						|| Character.toLowerCase(e.getKeyChar()) == 's') {
					feld.player.move(0, 1, feld);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT
						|| Character.toLowerCase(e.getKeyChar()) == 'd') {
					feld.player.move(1, 0, feld);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	Playground() {
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
