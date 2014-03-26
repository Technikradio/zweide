package zweide.tompong;

public class Ball {

	private int verticalMotion;
	private int vertPos;
	private double horiPos;
	private Player lastHitPlayer;
	private int speed;
	private int size;

	private int lowerPosBounds;
	private int upperPosBounds;
	
	public Ball(int Size, int x, int y) {
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getVerticalMotion() {
		return verticalMotion;
	}

	public void setVerticalMotion(int verticalMotion) {
		this.verticalMotion = verticalMotion;
	}

	public int getVertPos() {
		return vertPos;
	}

	public void setVertPos(int vertPos) {
		this.vertPos = vertPos;
	}

	public double getHoriPos() {
		return horiPos;
	}

	public void setHoriPos(double horiPos) {
		this.horiPos = horiPos;
	}

	public Player getLastHitPlayer() {
		return lastHitPlayer;
	}

	public void setLastHitPlayer(Player lastHitPlayer) {
		this.lastHitPlayer = lastHitPlayer;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLowerPosBounds() {
		return lowerPosBounds;
	}

	public void setLowerPosBounds(int lowerPosBounds) {
		this.lowerPosBounds = lowerPosBounds;
	}

	public int getUpperPosBounds() {
		return upperPosBounds;
	}

	public void setUpperPosBounds(int upperPosBounds) {
		this.upperPosBounds = upperPosBounds;
	}

}
