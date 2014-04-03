package zweide.tompong.powerups;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import zweide.tompong.Powerup;
import zweide.tompong.PowerupRegister.RegisterPowerup;
import zweide.tompong.Tompong;

@RegisterPowerup(notCommon = false)
public class LSD extends Powerup {
	public LSD(int x, int y) {
		super(x, y);
	}

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
	}

}
