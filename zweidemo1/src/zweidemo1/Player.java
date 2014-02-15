package zweidemo1;

public class Player {
	private String name = "Player";
	private int posx = 0, posy = 0;

	Player() {
		initPlayer("", 0, 0);
	}

	Player(String name) {
		initPlayer(name, 0, 0);
	}

	Player(int x, int y) {
		initPlayer("", x, y);
	}

	Player(String name, int x, int y) {
		initPlayer(name, x, y);
	}

	private void initPlayer(String name, int x, int y) {
		this.posx = x;
		this.posy = y;
		this.name = name;
	}
	
	void move(int x, int y) {
		this.posx += x;
		this.posy += y;
	}
	
}
