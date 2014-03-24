package zweide.tompong;

public class Level {
	public int barSpeed;
	public int ballSpeed;
	public int barHeight;
	public String name;

	@Override
	public String toString() {
		return "Level \"" + name + "\": BarSpeed: " + barSpeed
				+ ", BarHeight: " + barHeight + ", BallSpeed: " + ballSpeed
				+ ".";
	}
}
