package zweidemo2;

public class Player {

	int posx = 0, posy = 0, fieldx=0, fieldy=0;

	public Player(int x, int y) {
		fieldx = x;
		fieldy = y;
		posx = 32*fieldx;
		posy = 32*fieldy;
	}
	void slide(int x, int y, GamePanel board) {
		int movelength=0;
		for(int i=0;;i++) {
			if(fieldx+i*x<0||fieldx+i*x>=board.fields.length||fieldy+i*y<0||fieldy+i*y>=board.fields[0].length||!board.fields[fieldx+i*x][fieldy+i*y].isPassable) {
				movelength=i-1;
				break;
			}
		}
		fieldx += movelength*x;
		fieldy += movelength*y;
		posx=fieldx*32;
		posy=fieldy*32;
		board.repaint();
	}

}
