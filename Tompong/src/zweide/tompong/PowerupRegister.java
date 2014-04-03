package zweide.tompong;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class PowerupRegister {

	static ArrayList<Powerup> powerups;
	static int count = -1;

	static {
		/*powerups = new ArrayList<Powerup>();
		java.lang.Class<java.lang.Object>[] classes = null;
				
		powerups.add(new zweide.tompong.powerups.LSD(Resources.sizeX / 2,
				Resources.sizeY / 2));
		count++;

		for (int i = 0; i <= classes.length; i++) {
			if (classes[i].isAnnotationPresent(RegisterPowerup.class)) {
				try {
					powerups.add((Powerup) classes[i].newInstance());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					
				}
			}

		}*/
	}

	public static Powerup getNext() {
		if (count > -1)
			return (Powerup) powerups.toArray()[(int) Math
					.round((Math.random() * count))];
		else
			return new zweide.tompong.powerups.LSD(
					(int) ((Resources.sizeX - 32) * Math.random()),
					(int) ((Resources.sizeX - 32) * Math.random())); // This should return an random item
		// of powerups right?
	}

	@Documented
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface RegisterPowerup {
		boolean notCommon() default false;
	}
}
