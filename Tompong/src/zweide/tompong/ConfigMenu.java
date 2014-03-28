package zweide.tompong;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ConfigMenu extends JFrame implements ActionListener {
	JButton exitBT;
	JButton exitWithoutSavingBT; // Nice name right?
	JTextField translationTF;
	JLabel translationLB;
	JCheckBox fullscrennCB;
	JTextField sizeXTF;
	JLabel sizeXLB;
	JTextField sizeYTF;
	JLabel sizeYLB;

	public ConfigMenu() {
		getContentPane().setLayout(null);
		setupGUI();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void setupGUI() {
		exitBT = new JButton();
		exitBT.setLocation(400, 428);
		exitBT.setSize(100, 50);
		exitBT.setText("OK");
		exitBT.addActionListener(this);
		add(exitBT);

		exitWithoutSavingBT = new JButton();
		exitWithoutSavingBT.setLocation(300, 428);
		exitWithoutSavingBT.setSize(100, 50);
		exitWithoutSavingBT.setText("Abort");
		exitWithoutSavingBT.addActionListener(this);
		add(exitWithoutSavingBT);

		sizeXTF = new JTextField();
		sizeXTF.setLocation(90, 25);
		sizeXTF.setSize(400, 35);
		add(sizeXTF);

		sizeYTF = new JTextField();
		sizeYTF.setLocation(90, 60);
		sizeYTF.setSize(400, 35);
		add(sizeYTF);
		
		translationTF = new JTextField();
		translationTF.setLocation(90, 100);
		translationTF.setSize(400, 35);
		add(translationTF);

		sizeXLB = new JLabel();
		sizeXLB.setLocation(5, 25);
		sizeXLB.setText("Height:");
		sizeXLB.setSize(75, 25);
		add(sizeXLB);

		sizeYLB = new JLabel();
		sizeYLB.setLocation(5, 55);
		sizeYLB.setText("Width:");
		sizeYLB.setSize(75, 25);
		add(sizeYLB);
		
		translationLB = new JLabel();
		

		setResizable(false);
		setTitle("Settings");
		setSize(500, 500);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 390) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 310) / 2);
	}

	public void writeConfig() {
		System.out.println("Write to settingsfile");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exitBT) {
			writeConfig();
			dispose();
		} else if (e.getSource() == exitWithoutSavingBT) {
			dispose();
		}
	}
}
