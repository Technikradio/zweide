package zweide.tompong;

public class Ball {

	private int verticalMotion;
	private int horizontalDirection;

	private int vertPos;
	private double horiPos;

	private int speed;

	private int size;

	private Player lastHitPlayer;

	private int lowerPosBounds;
	private int upperPosBounds;

	public Ball(int size, int x, int y) {
		this.size = size;
		this.horiPos = (int) x;
		this.vertPos = y;
	}

	/*
	 * @returns: the distance to move the ball sideways
	 */
	public int getHorizontalDistance() {
		return (int) Math.round(Math.sqrt(speed * speed - verticalMotion
				* verticalMotion));
	}

	// Standard GETTERS/SETTERS

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getVerticalMotion() {
		return verticalMotion;
	}

	public void setVerticalMotion(int vm) {
		if (Math.abs(vm) >= speed)
			this.verticalMotion = vm > 0 ? speed - 1 : -(speed - 1);
		else
			this.verticalMotion = vm;
	}

	public int getVertPos() {
		return vertPos;
	}

	public void setVertPos(int vertPos) {
		this.vertPos = vertPos;
	}

	public int getHoriPos() {
		return (int) Math.round(horiPos);
	}

	public void setHoriPos(double horiPos) {
		this.horiPos = horiPos;
	}

	public void setPos(int x, int y) {
		this.horiPos = x;
		this.vertPos = y;
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

	public int getUpperPosBounds() {
		return upperPosBounds;
	}

	public void setPosBounds(int lowerPosBounds, int upperPosBounds) {
		this.upperPosBounds = upperPosBounds;
		this.lowerPosBounds = lowerPosBounds;
	}

	public int getHorizontalDirection() {
		return horizontalDirection;
	}

	public void setHorizontalDirection(int horizontalDirection) {
		this.horizontalDirection = horizontalDirection;
	}

}
