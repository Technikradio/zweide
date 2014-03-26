package zweide.tompong;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener
{
    JButton EasyButto;
     JButton mediu;
     JButton har;
     JButton costum;
     
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
	setVisible(true);
	setResizable(false);
   }
   
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == EasyButto){
            Tompong.menu_OnEasyClick();
        }
        if(e.getSource() == mediu){
            Tompong.menu_OnMediumClick();
        }
        if(e.getSource() == har){
            Tompong.menu_OnHardClick();
        }
        if(e.getSource() == costum){
            Tompong.menu_OnCostumClick();
        }
    }
}  

