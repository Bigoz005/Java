package Arkanoid;

import java.awt.*;

public class Ball {

	public static int standartBallRadius = 4;
	private Point pos = new Point(0,0);
	private int radius;
	
	
	public Ball(int x, int y, int radius) {
		pos = new Point(x,y);
		this.radius = radius;
		
	}
	
 public void render(Graphics g) {

	 g.setColor(new Color(0,0,0));
	 g.fillOval(pos.x-radius, pos.y-radius, radius*2, radius*2);
 
 }
}

