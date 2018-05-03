package Arkanoid;
import java.awt.*;
import javax.swing.*;


public class Main {

	
	public static void main(String[] args) {
	Gameplay game= new Gameplay();
	JFrame frame = new JFrame();
	frame.setTitle("Arkanoid");
	frame.setBounds(10,10,700,600);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(game);
	
	
	game.setSize(frame.getSize());
	
	
	
	
	}
	
}
