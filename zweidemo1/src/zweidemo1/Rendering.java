package zweidemo1;

import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class Rendering extends JFrame{
	public Rendering(){
		add(new RenderBoard());
		setTitle(Properties.name);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Properties.resulotionW, Properties.resulotionH);
		setResizable(Properties.resizable);
		
	}
	
	public static void main(String[] args){
		new Rendering();
	}
}



public class RenderBoard extends JPanel{
    public void paint(Graphics g)
    {
    	{
    		super.paint(g);
    		Graphics2D g2 = (Graphics2D) g;
    		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    		g2.setRenderingHints(rh);
    	}
    	//Time for some redering!
    }
}