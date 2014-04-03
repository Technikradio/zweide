package zweide.tompong;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@SuppressWarnings( "unused" )
public class PowerupRegister {
	
	static ArrayList<Powerup> powerups;
	static int count = 0;
	
	static{
		powerups = new ArrayList<Powerup>();
		java.lang.Class<java.lang.Object>[] classes = null/* = GetAllClasses() oder so?*/; //Get all classes of zweide.tompong
		powerups.add(new zweide.tompong.powerups.LSD(Resources.sizeX / 2, Resources.sizeY / 2));
		/*
		for(int i = 0; i <= classes.length; i++){
			if(classes[i].getClass().isAnnotationPresent(RegisterPowerup.class)){
				try {
					powerups.add((Powerup) classes[i].newInstance());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/
	}
	
	public static Powerup getNext(){
		if(count > 0) return (Powerup) powerups.toArray()[(int) Math.round(Math.random() * count - 1)]; else return null; // This should return an random item of powerups right?
	}
	
	@Documented
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface RegisterPowerup{boolean notCommon() default false;}
}
