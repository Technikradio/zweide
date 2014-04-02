package zweide.tompong;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {
  JButton EasyButto;
  JButton mediu;
  JButton har;
  JButton costum;
  JButton config;
  JTextField ballSpeedTF;
  JTextField barHeightTF;
  JTextField barSpeedTF;
  JLabel ballSpeedLB;
  JLabel barHeightLB;
  JLabel barSpeedLB;
  JButton cSubmitt;

  GameFrame gameframe;

  public Menu() {
    getContentPane().setLayout(null);
    setupGUI();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  void setupGUI() {
    config = new JButton();
    config.setLocation(0, 70 * 4 + 5);
    config.setSize(390, 70);
    config.setText("Settings");
    config.addActionListener(this);
    add(config);

    EasyButto = new JButton();
    EasyButto.setLocation(0, 0);
    EasyButto.setSize(390, 70);
    EasyButto.setText("Easy");
    EasyButto.addActionListener(this);
    getContentPane().add(EasyButto);

    mediu = new JButton();
    mediu.setLocation(0, 70);
    mediu.setSize(390, 70);
    mediu.setText("Medium");
    mediu.addActionListener(this);
    getContentPane().add(mediu);

    har = new JButton();
    har.setLocation(0, 140);
    har.setSize(390, 70);
    har.setText("Hard");
    har.addActionListener(this);
    getContentPane().add(har);

    costum = new JButton();
    costum.setLocation(0, 210);
    costum.setSize(390, 70);
    costum.setText("Costum");
    costum.addActionListener(this);
    getContentPane().add(costum);

    ballSpeedTF = new JTextField();
    ballSpeedTF.setLocation(395, 0 + 35);
    ballSpeedTF.setSize(390, 35);
    ballSpeedTF.setVisible(false);
    add(ballSpeedTF);

    barHeightTF = new JTextField();
    barHeightTF.setLocation(395, 70 + 30);
    barHeightTF.setSize(390, 35);
    barHeightTF.setVisible(false);
    add(barHeightTF);

    barSpeedTF = new JTextField();
    barSpeedTF.setLocation(395, 140 + 30);
    barSpeedTF.setSize(390, 35);
    barSpeedTF.setVisible(false);
    add(barSpeedTF);

    cSubmitt = new JButton();
    cSubmitt.setLocation(395, 210);
    cSubmitt.setSize(390, 70);
    cSubmitt.setText("OK & Play");
    cSubmitt.addActionListener(this);
    add(cSubmitt);

    ballSpeedLB = new JLabel();
    ballSpeedLB.setLocation(400, 10);
    ballSpeedLB.setSize(390, 35);
    ballSpeedLB.setText("Ball Speed");
    ballSpeedLB.setVisible(false);
    add(ballSpeedLB);

    barHeightLB = new JLabel();
    barHeightLB.setLocation(400, 55);
    barHeightLB.setSize(390, 35);
    barHeightLB.setText("bar Height");
    barHeightLB.setVisible(false);
    add(barHeightLB);

    barSpeedLB = new JLabel();
    barSpeedLB.setLocation(400, 140);
    barSpeedLB.setSize(390, 35);
    barHeightLB.setSize(390, 70);
    barSpeedLB.setText("Bar Speed");
    barSpeedLB.setVisible(false);
    add(barSpeedLB);

    setTitle("menu");
    setSize(392, 70 * 6 - 35);

    // TODO hard coded size 390/310

    {
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      int posx = (d.width - 390) / 2;
      int posy = (d.height - 310) / 2;
      setLocation(posx, posy);
    }

    setResizable(false);
  }

  public void call(GameFrame gameframe) {
    this.setVisible(true);
    this.gameframe = gameframe;
  }

  public void menu_OnClick(int index) {
    Resources.levelIndex = (byte) index;
    gameframe.pong.setCurrentLevel(Resources.getLevels()[index]);
    Resources.menu.setVisible(false);
    gameframe.setVisible(true);
  }

  public void menu_OnCostumClick() {
    // TODO implement custom menu
    cSubmitt.setVisible(true);
    ballSpeedTF.setVisible(true);
    barSpeedTF.setVisible(true);
    barHeightTF.setVisible(true);
    ballSpeedLB.setVisible(true);
    barSpeedLB.setVisible(true);
    barHeightLB.setVisible(true);
    config.setSize(390 * 2 + 5, 70);
    for(int i = 392; i <= 392 * 2 + 3; i += 3){
      setSize(i, 70*6-35);
      try {
        Thread.sleep((long) 5);
      } catch (InterruptedException e) {;}
    }
    setSize(392 * 2 + 3, 70 * 6 - 35);
  }

  void menu_OnSubmittClick() {
    Level cl = new Level();
    cl.name = "costum";
    cl.barSpeed = Integer.parseInt(barSpeedTF.getText());
    cl.barHeight = Integer.parseInt(barHeightTF.getText());
    cl.ballSpeed = Integer.parseInt(ballSpeedTF.getText());
    Resources.levelIndex = (byte) 4;
    Resources.costumLevel = cl;
    Resources.menu.setVisible(false);
    gameframe.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == EasyButto) {
      menu_OnClick(0);
    } else if (e.getSource() == mediu) {
      menu_OnClick(1);
    } else if (e.getSource() == har) {
      menu_OnClick(2);
    } else if (e.getSource() == costum) {
      menu_OnCostumClick();
    } else if (e.getSource() == cSubmitt) {
      menu_OnSubmittClick();
    } else if (e.getSource() == config) {
      ConfigMenu cm = new ConfigMenu();
      this.setVisible(false);
      cm.setVisible(true);
    }

    //Resources.gameThread.resume();
    GBAE.play();

  }
}
