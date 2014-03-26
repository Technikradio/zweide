package zweide.tompong;

public class Resources {

	public static final Level[] levels;
	public static final int defaultLevelIndex=1;
	public static final int sizeX = 800;
	public static final int sizeY = 600;

	public static byte levelIndex = defaultLevelIndex;

	static{
		levels = new Level[3];
		{
			Level l = new Level();
			l.name = "easy";
			l.barSpeed=10;
			l.barHeight=80;
			l.ballSpeed = 5;
			levels[0] = l;
		}
		{ // Level medium
			Level l = new Level();
			l.name = "medium";
			l.barSpeed=10;
			l.barHeight=64;
			l.ballSpeed = 10;
			levels[1] = l;
		}
		{ // Level hard
			Level l = new Level();
			l.name = "hard";
			l.barSpeed=5;
			l.ballSpeed = 10;
			l.barHeight=48;
			levels[2] = l;
		}
	}
	
	public static Level[] getLevels() {
		return levels;
	}
	
	public static Level getDefaultLevel() {
		return levels[defaultLevelIndex];
	}
	
	public static byte getCurrentLevel(){
		return levelIndex;
	}
}
