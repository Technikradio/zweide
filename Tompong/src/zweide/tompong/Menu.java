package zweide.tompong;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener
{
    JButton EasyButto;
     JButton mediu;
     JButton har;
     JButton costum;
     
     GameFrame gameframe;
     
   public Menu()
   {
     getContentPane().setLayout(null);
     setupGUI();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void setupGUI()
   {
     	EasyButto = new JButton();
	EasyButto.setLocation(0,0);
	EasyButto.setSize(390,70);
	EasyButto.setText("Easy");
	EasyButto.addActionListener(this);
	getContentPane().add(EasyButto);

	mediu = new JButton();
	mediu.setLocation(0,70);
	mediu.setSize(390,70);
	mediu.setText("Medium");
	mediu.addActionListener(this);
	getContentPane().add(mediu);

	har = new JButton();
	har.setLocation(0,140);
	har.setSize(390,70);
	har.setText("Hard");
	har.addActionListener(this);
	getContentPane().add(har);

	costum = new JButton();
	costum.setLocation(0,210);
	costum.setSize(390,70);
	costum.setText("Costum");
	costum.addActionListener(this);
	getContentPane().add(costum);

	setTitle("menu");
	setSize(390,310);
	setResizable(false);
   }
   
   public void call(GameFrame gameframe) {
	   this.setVisible(true);
	   this.gameframe = gameframe;
   }
   
   public void menu_OnEasyClick(){
		Resources.levelIndex = 0;
		Resources.menu.setVisible(false);
		gameframe.setVisible(true);
	}
	
	public void menu_OnMediumClick(){
		Resources.levelIndex = 1;
		Resources.menu.setVisible(false);
		gameframe.setVisible(true);
	}

	public void menu_OnHardClick(){
		Resources.levelIndex = 2;
		Resources.menu.setVisible(false);
		gameframe.setVisible(true);
	}
	
	public void menu_OnCostumClick(){
		//TODO implement custom menu
		Resources.menu.setVisible(false);
		gameframe.setVisible(true);
	}
   
    public void actionPerformed(ActionEvent e) {  	
        if(e.getSource() == EasyButto){
            menu_OnEasyClick();
        }
        else if(e.getSource() == mediu){
            menu_OnMediumClick();
        }
        else if(e.getSource() == har){
            menu_OnHardClick();
        }
        else if(e.getSource() == costum){
            menu_OnCostumClick();
        }
        
        Resources.gameThread.resume();
        
    }
}  

