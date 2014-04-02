package zweide.tompong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener, MouseListener {

  public PongPanel pong;

  public GameFrame() {
    // int x = 800;
    // int y = 600;
    int x = Resources.sizeX;
    int y = Resources.sizeY;
    setSize(x, y);
    setTitle("Tompong" + " :: " + " Use directional keys and right click!");
    {
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      int posx = (d.width - x) / 2;
      int posy = (d.height - y) / 2;
      setLocation(posx, posy);
    }
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setBackground(Color.black);

    pong = new PongPanel(x, y);
    add(pong);

    this.addKeyListener(this);
    this.addMouseListener(this);

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
  
  public void initGameThread(){
	  pong.createThread();
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (e.isPopupTrigger()) {
      Resources.menu.call(this);
      GBAE.pause();
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

}
