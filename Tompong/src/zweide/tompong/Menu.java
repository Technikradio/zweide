package zweide.tompong;

import javax.swing.JButton;
import javax.swing.JFrame;
Import javax.swing.JTextField;

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
        JTextField ballSpeedTF;
        JTextField barHeightTF;
        JTextField barSpeedTF;
        JButton cSubmitt;

	GameFrame gameframe;

	public Menu() {
		getContentPane().setLayout(null);
		setupGUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void setupGUI() {
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
                ballSpeedTF.setLocation(395, 0);
                ballSpeedTF.setSize(390, 70);
                ballSpeedTF.setVisible(false);
                add(ballSpeedTF);

                barHeightTF = new JTextField();
                barHeightTF.setLocation(395, 70);
                barHeightTF.setSize(390, 70);
                barHeightTF.setVisible(false);
                add(barHeightTF);

                barSpeedTF = new JTextField();
                barSpeedTF.setLocation(395, 140);
                barSpeedTF.setSize(390, 70);
                barSpeedTF.setVisible(false);
                add(barSpeedTF);

                cSubmitt = new JButton();
                cSubmitt.setLocation(395, 210);
                cSubmitt.setSize(390, 70);
                cSubmitt.setText("OK & Play");
                cSubmitt.addActionListener(this);
                add(cSubmitt);

		setTitle("menu");
		setSize(392, 310);

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
                setSize(392 * 2, 310);
                cSubmitt.setVisible(true);
                ballSpeedTF.setVisible(true);
                barSpeedTF.setVisible(true);
                barHeightTF.setVisible(true);
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
                }

		Resources.gameThread.resume();

	}
}
