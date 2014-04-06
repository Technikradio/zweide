package zweide.tompong.powerups;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import zweide.tompong.Powerup;
import zweide.tompong.PowerupRegister.RegisterPowerup;
import zweide.tompong.Resources;

@RegisterPowerup(notCommon = false)
public class LSD extends Powerup implements Runnable {
	public LSD(int x, int y) {
		super(x, y);
	}
	
	private Thread thread = null;

	private static final long serialVersionUID = -955585109436097068L;

	@Override
	public void draw(Graphics g) {
		g.drawRect((int) getX(), (int) getY(), 32, 32);
		g.setFont(new Font("Arial", Font.BOLD, 12));
		g.drawString("LSD", (int)getX()+5, (int)getY()+20);
	}

	@Override
	public void onEvent() {
		System.out.println("LSD");
		thread = new Thread(this);
		thread.run();
	}

	@Override
	public void run() {
		int k = (int)(Math.random() * (Math.random() + 1.5d) * 100); //How long?
		int t = (int)Math.random() * 100; //How strange?
		for(int i = 0; i <= k; i++){
			Resources.setPanelBackgroundColor(getRandomColor());
			try {
				Thread.sleep((long) t);
			} catch (InterruptedException e) {
				System.out.println("Fails to sleep");
				e.printStackTrace();
			}
		}
		Resources.setPanelBackgroundColor(Color.BLACK);
	}

	private Color getRandomColor() {
		double c = Math.random();
		if(c < 0.05){
			return Color.WHITE;
		} else if(c < 0.1){
			return Color.BLUE;
		} else if(c < 0.2){
			return Color.CYAN;
		} else if(c < 0.3){
			return Color.DARK_GRAY;
		} else if (c < 0.4){
			return Color.LIGHT_GRAY;
		} else if (c < 0.5){
			return Color.GREEN;
		} else if (c < 0.6){
			return Color.MAGENTA;
		} else if (c < 0.7){
			return Color.ORANGE;
		} else if (c < 0.8){
			return Color.PINK;
		} else if (c < 0.9){
			return Color.RED;
		} else if (c < 0.95) return Color.YELLOW;
		
		return Color.BLACK;
	}

}
