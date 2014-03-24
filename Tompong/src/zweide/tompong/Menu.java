package zweide.tompong;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame
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
	EasyButto.setSize(391,70);
	EasyButto.setText("Easy");
	getContentPane().add(EasyButto);

	mediu = new JButton();
	mediu.setLocation(0,70);
	mediu.setSize(392,70);
	mediu.setText("Medium");
	getContentPane().add(mediu);

	har = new JButton();
	har.setLocation(0,140);
	har.setSize(391,70);
	har.setText("Hard");
	getContentPane().add(har);

	costum = new JButton();
	costum.setLocation(0,210);
	costum.setSize(390,70);
	costum.setText("Costum");
	getContentPane().add(costum);

	setTitle("men");
	setSize(400,309);
	setVisible(true);
	setResizable(false);
	
	
   }
}  

