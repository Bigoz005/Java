package Arkanoid;

import java.awt.*;

public class Player {
	
	public static int standardPlayerWidth = 50;
	public static int standardPlayerHeight = 10;
	private static Rectangle hitBox;
	private static Game instance;
	
	public Player(Game inst, int x, int y, int width, int height) {
		instance = inst;
		hitBox = new Rectangle(x, y, width, height);
	}
	
	public static void moveOnXAxis(int speed)  {
		hitBox.x += speed;
		if(hitBox.x < 0) hitBox.x = 1;
		instance.getPlayer();
		if(hitBox.x > instance.getGameDimension().width-Player.hitBox.width) {
			instance.getPlayer();
			hitBox.x = instance.getGameDimension().width-Player.hitBox.width;
		}
		
	}
	
	public void setX(int x) {
		hitBox.x=x;
		}
	
	public void setY(int y) {
	hitBox.y=y;
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(200,200,200));
		g.fillRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
	}
}
