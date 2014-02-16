package zweidemo1;
import javax.swing.JFrame;

public class Rendering extends JFrame{
	public Rendering(){
		add(new Board());
		setTitle(Properties.name);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Properties.resulotionW, Properties.resulotionH);
	}
}