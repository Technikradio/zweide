package zweidemo1;

public class Player {
	String name = "";
	int posx = 0, posy = 0;

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

	boolean move(int x, int y, Board board) {
		if(posx + x<0||posy + y<0)
			return false;
		if(!(posx + x<board.WIDTH&&posy + y<board.HEIGHT))
			return false;
		if (!board.validfloor[posx + x][posy + y])
			return false;
		this.posx += x;
		this.posy += y;
		board.repaint();
		return true;
	}

}
