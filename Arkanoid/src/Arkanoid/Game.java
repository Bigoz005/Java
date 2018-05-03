package Arkanoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;

public class Game extends JPanel{
	private Dimension gameField = new Dimension(400,300);
	private boolean isRunning = false;
	private Player player;
	private Ball ball;
	
	
	public Game(Frame container){
		
		container.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				isRunning = true;
				if (!isRunning) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) start();
				}else {
					if(e.getKeyCode()==KeyEvent.VK_RIGHT) player.moveOnXAxis(10);
					if(e.getKeyCode()==KeyEvent.VK_LEFT) player.moveOnXAxis(-10);
				}
				repaint();
			}
		});
		player = new Player(this, (int) ((gameField.getWidth()-Player.standardPlayerWidth)/2),(gameField.height-Player.standardPlayerHeight)/2, Player.standardPlayerWidth, Player.standardPlayerHeight);
		ball = new Ball(gameField.width/2,gameField.height/2, Ball.standartBallRadius);
	}
	
	Thread gameThread = new Thread(new Runnable() {
		public void run() {
			isRunning= true;
			while(isRunning) {
			
				repaint();
			
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	});
	
	
	public void start() {
		gameThread.start();
	}
	public void pause() {
		gameThread.stop();
	}
	public void stop() {
		isRunning = false;
	}
	public Dimension getGameDimension() {
		return gameField;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getPlayer() {
		return this.player;
	}

	public void setSize(Dimension size) {
		super.setSize(size);
		//if(!isRunning) {
			gameField = new Dimension(size.width-200, size.height-200);
			player.setX((int) ((gameField.getWidth()-Player.standardPlayerWidth)/2));
			player.setY(gameField.height-player.standardPlayerHeight);
		//}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	
		g.translate((this.getWidth()-gameField.width)/2, (this.getHeight()-gameField.height)/2 );
		//g.fillRect(100, 100, 10, 10);
		
		g.setColor(new Color(255,255,255,100));
		g.fillRect(0, 0, gameField.width, gameField.height);
		
		player.render(g);
		
		g.setColor(new Color(0,0,0));
		g.drawRect(0, 0, gameField.width, gameField.height);
	
		
	}
}
