package zweide.tompong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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

    playerL.setKEYCODE_UP(38);
    playerL.setKEYCODE_DOWN(40);

    playerR.setKEYCODE_UP(107);
    playerR.setKEYCODE_DOWN(10);

    setCurrentLevel(Resources.getDefaultLevel());

    Resources.gameThread = new Thread(this);
    Resources.gameThread.start();
  }

  @Override
  public void run() {

    // initialize
    long startTime, elapsedTime;
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    mainBall.setVerticalMotion((int) ((double) (-currentLevel.ballSpeed / 2) + (double) Math
        .random() * (double) (currentLevel.ballSpeed)));
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

    while (GBAE.running == true) {

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

      // Hitbox (?? how was it called??)
      if (new Rectangle(mainBall.getHoriPos(), mainBall.getVertPos(),
          mainBall.getSize(), mainBall.getSize()).intersects(27,
          playerL.getPos(), 10, playerL.getBarHeight())) {
        // Ball is in left player
        mainBall.setHorizontalDirection(1);
        mainBall.setVerticalMotion((int) Math.round(mainBall
            .getVerticalMotion()
            - (double) ((playerL.getPos() + playerL.getBarHeight() / 2) - (mainBall
                .getVertPos() + mainBall.getSize() / 2))
            / playerL.getBarHeight() * currentLevel.ballSpeed));
      }
      if (new Rectangle(mainBall.getHoriPos(), mainBall.getVertPos(),
          mainBall.getSize(), mainBall.getSize()).intersects(
          frameWidth - 37, playerR.getPos(), 10,
          playerR.getBarHeight())) {
        // Ball is in right player
        mainBall.setHorizontalDirection(-1);
        mainBall.setVerticalMotion((int) Math.round(mainBall
            .getVerticalMotion()
            - (double) ((playerR.getPos() + playerR.getBarHeight() / 2) - (mainBall
                .getVertPos() + mainBall.getSize() / 2))
            / playerR.getBarHeight() * currentLevel.ballSpeed));
      }
      if (mainBall.getVertPos() + mainBall.getSize() > mainBall
          .getUpperPosBounds()) {
        // ball is at low border
        mainBall.setVerticalMotion(-1
            * Math.abs(mainBall.getVerticalMotion()));
      }
      if (mainBall.getVertPos() < mainBall.getLowerPosBounds()) {
        // ball is at low border
        mainBall.setVerticalMotion(Math.abs(mainBall
            .getVerticalMotion()));
      }
      if (mainBall.getHoriPos() < 0) {
        // Ball left goal
        mainBall.setPos(frameWidth / 2 - 8, frameHeight / 2 - 8);
        newBallParameter();
        playerR.setScore(playerR.getScore() + 1);
      }
      if (mainBall.getHoriPos() + mainBall.getSize() > frameWidth) {
        // Ball right goal
        newBallParameter();
        playerL.setScore(playerL.getScore() + 1);
      }

      // Repaint
      repaint();

      // Calculate elapsed time
      elapsedTime = System.currentTimeMillis() - startTime;
      if (elapsedTime > 1) {
        System.out.println("Frame Time high: " + elapsedTime
            + " Time: " + timeFormat.format(new Date()));
      }

      // Wait
      try {
        Thread.sleep((elapsedTime < 20) ? (20 - elapsedTime) : 1L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void newBallParameter() {
    mainBall.setVerticalMotion((int) ((double) (-currentLevel.ballSpeed / 2) + (double) Math
        .random() * (double) (currentLevel.ballSpeed)));
    mainBall.setPos(frameWidth / 2 - mainBall.getSize() / 2, frameHeight
        / 2 - mainBall.getSize() / 2);
    mainBall.setHorizontalDirection(-mainBall.getHorizontalDirection());
  }

  @Override
  protected void paintComponent(Graphics g) {

    // General
    super.paintComponent(g);
    g.setColor(Color.white);

    // Player
    g.fillRect(27, playerL.getPos(), 10, playerL.getBarHeight());
    g.fillRect(frameWidth - 37, playerR.getPos(), 10,
        playerR.getBarHeight());

    // Ball
    g.fillRect(mainBall.getHoriPos(), mainBall.getVertPos(),
        mainBall.getSize(), mainBall.getSize());

    // dividing Line
    for (int i = 0; i < frameHeight; i += 32) {
      g.fillRect(getWidth() / 2 - 1, i, 2, 16);
    }

    // Score
    g.drawString(Integer.toString(playerL.getScore()), 300, 100);
    g.drawString(Integer.toString(playerR.getScore()), 500, 100);

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

