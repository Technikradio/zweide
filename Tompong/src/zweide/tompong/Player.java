package zweide.tompong;

public class Player {

	private int barHeight=64;
	
	private int score = 0;
	
	private int pos = 0;
	
	private int lowestPos;
	private int highestPos;

	private int KEYCODE_UP;
	private int KEYCODE_DOWN;

	private boolean goingUp=false;
	private boolean goingDown=false;

	private int movement=0;
	
	private void updateMovement() {
		movement=0;
		if(goingUp)
			movement--;
		if(goingDown)
			movement++;
	}

	public void setPosBounds(int lowest, int highest) {
		lowestPos=lowest;
		highestPos=highest;
	}

	public int getBarHeight() {
		return barHeight;
	}

	public void setBarHeight(int barHeight) {
		this.barHeight = barHeight;
	}

	public boolean isGoingUp() {
		return goingUp;
	}

	public boolean isGoingDown() {
		return goingDown;
	}

	public void setGoingUp(boolean goingUp) {
		this.goingUp = goingUp;
		updateMovement();
	}

	public void setGoingDown(boolean goingDown) {
		this.goingDown = goingDown;
		updateMovement();
	}

	public int getMovement() {
		return movement;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
		if(this.pos<this.lowestPos)
			this.pos=this.lowestPos;
		if(this.pos>this.highestPos-this.barHeight)
			this.pos=this.highestPos-this.barHeight;
	}

	public int getKEYCODE_UP() {
		return KEYCODE_UP;
	}

	public void setKEYCODE_UP(int keycode) {
		KEYCODE_UP = keycode;
	}

	public int getKEYCODE_DOWN() {
		return KEYCODE_DOWN;
	}

	public void setKEYCODE_DOWN(int keycode) {
		KEYCODE_DOWN = keycode;
	}

}
