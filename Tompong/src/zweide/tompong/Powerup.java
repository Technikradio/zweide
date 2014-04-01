package zweide.tompong;
import java.awt.*;
abstract class Powerup extends Rectangle{

private int posX, posY;

public Powerup(int x, int y){
posX = x;
posY = y;
}
public abstract void Draw(Graphics g) {}
}
