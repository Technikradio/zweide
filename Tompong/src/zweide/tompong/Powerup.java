package zweide.tompong;
import java.awt.*;
abstract class Powerup extends Rectangle{

private static final long serialVersionUID = 6025508732807590382L;
private int posX, posY;

public Powerup(int x, int y){
setPosX(x);
setPosY(y);
}
public abstract void Draw(Graphics g);
public int getPosY() {
	return posY;
}
public void setPosY(int posY) {
	this.posY = posY;
}
public int getPosX() {
	return posX;
}
public void setPosX(int posX) {
	this.posX = posX;
}
}
