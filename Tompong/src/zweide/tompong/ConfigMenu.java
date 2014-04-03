package zweide.tompong;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ConfigMenu extends JFrame implements ActionListener, ChangeListener {
	JButton exitBT;
	JButton exitWithoutSavingBT; // Nice name right?
	JTextField translationTF;
	JLabel translationLB;
	JCheckBox fullscreenCB;
	JTextField sizeXTF;
	JLabel sizeXLB;
	JTextField sizeYTF;
	JLabel sizeYLB;
	boolean fullscreenCBChecked;

	public ConfigMenu() {
		getContentPane().setLayout(null);
		setupGUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		sizeXTF.setText(String.valueOf(Resources.sizeX));
		add(sizeXTF);

		sizeYTF = new JTextField();
		sizeYTF.setLocation(90, 60);
		sizeYTF.setSize(400, 35);
		sizeYTF.setText(String.valueOf(Resources.sizeY));
		add(sizeYTF);
		
		translationTF = new JTextField();
		translationTF.setLocation(90, 150);
		translationTF.setSize(400, 35);
		translationTF.setText(Resources.getCurrentTranslation());
		add(translationTF);
		
		fullscreenCB = new JCheckBox();
		fullscreenCB.setLocation(90, 100);
		fullscreenCB.setText("Enter fullscreen");
		fullscreenCB.setSize(400, 35);
		fullscreenCB.setSelected(Resources.getFullscreenMode());
		fullscreenCB.addChangeListener(this);
		add(fullscreenCB);
		fullscreenCBChecked = Resources.getFullscreenMode();

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
		translationLB.setLocation(5, 155);
		translationLB.setText("translation");
		translationLB.setSize(75, 25);
		add(translationLB);

		setResizable(false);
		setTitle("Settings");
		setSize(500, 500);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 390) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 310) / 2);
	}

	public void writeConfig() {
		System.out.println("Write to settingsfile");
        PrintWriter pWriter = null; 
        try { 
            pWriter = new PrintWriter(new FileWriter("settings.cfg")); 
            pWriter.println("sizeX=" + sizeXTF.getText());
            pWriter.println("sizeY=" + sizeYTF.getText());
            pWriter.println("fullscreen=" + fullscreenCBChecked);
            pWriter.println("translation=" + translationTF.getText());
        } catch (IOException e) {
        	System.out.println("Fail to save settings");
            e.printStackTrace(); 
        } finally { 
            if (pWriter != null) 
                pWriter.flush(); 
        }
        System.out.println("Done!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitBT) {
			writeConfig();
			dispose();
		} else if (e.getSource() == exitWithoutSavingBT) {
			dispose();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == fullscreenCB){
			fullscreenCBChecked = !fullscreenCBChecked;
		}
	}
}
