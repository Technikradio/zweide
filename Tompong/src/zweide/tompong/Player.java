package zweide.tompong;

public class Player {

	private int score = 0;
	private int pos = 0;

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
		System.out.println(movement);
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
