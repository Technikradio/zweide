package zweide.tompong;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Translation { // Gibt es eigentlich structures in Java?

	public final String language;

	public static class ConfigMenu {
		public static String exitBT;
		public static String exitWithoutSavingBT;
		public static String translationLB;
		public static String fullscreenCB;
		public static String sizeXLB;
		public static String sizeYLB;
	}
	
	public static class Menu{
		public static String ballSpeedLB;
		public static String barHeightLB;
		public static String barSpeedLB;
		public static String cSubmitt;
		public static String EasyButto;
		public static String mediu;
		public static String har;
		public static String costum;
		public static String config;
	}

	public Translation() {
		language = Resources.getCurrentTranslation();
		loadStrings();
		System.out.println("Succsessfully loaded translation");
	}

	private void loadStrings() {
		Hashtable<String, String> d = new Hashtable<String, String>();
		{
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(language));
	            String line = null;
	            while((line = reader.readLine()) != null) {
	            	d.put(line.split("=")[0], line.split("=")[1]);
	            }
			} catch (FileNotFoundException e) {
				System.out.println("translationfile not found"); // Will never happen if we do everything right
				e.printStackTrace();
				return;
			} catch (IOException e){
				e.printStackTrace();
			} finally {
				if(reader != null){
					try {
						reader.close();
					} catch (IOException e) {
						System.out.println("Can´t close BufferedReader");
						e.printStackTrace();
					}
				}
			}
		}
		System.gc();
		ConfigMenu.exitBT = getValue(d, "ConfigMenu.exitBT", "OK");
		ConfigMenu.exitWithoutSavingBT = getValue(d, "ConfigMenu.exitWithoutSavingBT", "Abort");
		ConfigMenu.fullscreenCB = getValue(d, "ConfigMenu.fullscreenCB", "Enter fullscreen");
		ConfigMenu.sizeXLB = getValue(d, "ConfigMenu.sizeXLB", "Width:");
		ConfigMenu.sizeYLB = getValue(d, "ConfigMenu.sizeYLB", "Height:");
		ConfigMenu.translationLB = getValue(d, "ConfigMenu.translationLB", "translation:");
		
		Menu.ballSpeedLB = getValue(d, "Menu.ballSpeedLB", "Ball Speed");
		Menu.barHeightLB = getValue(d, "Menu.barHeightLB", "Bar Height");
		Menu.barSpeedLB = getValue(d, "Menu.barSpeedLB", "Bar Speed");
		Menu.config = getValue(d, "Menu.config", "Settings");
		Menu.costum = getValue(d, "Menu.costum", "Costum Level");
		Menu.cSubmitt = getValue(d, "Menu.cSubmitt", "OK & Play");
		Menu.EasyButto = getValue(d, "Menu.EasyButto", "Easy");
		Menu.har = getValue(d, "Menu.har", "Hard");
		Menu.mediu = getValue(d, "Menu.mediu", "Medium");
	}
	
	private String getValue(Hashtable<String, String> d, String k, String standert){
		String s = d.get(k);
		if(s != null){
			return s;
		} else {
			return standert;
		}
	}
	
	@SuppressWarnings("unused")
	private String getValue(Hashtable<String, String> d, String k){
		String s = d.get(k);
		if(s != null){
			return s;
		} else {
			return "";
		}
	}

}
