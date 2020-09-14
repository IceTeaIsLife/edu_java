package Practice_8;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.*;

public class DrawShapes extends JFrame {
	private int frameWidth = 1280, frameHeight = 720;

	public DrawShapes() {
		setBounds(100, 100, frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, frameWidth, frameHeight);
		Oval oval = new Oval(1,1,1,1,Color.BLACK);
		java.awt.Rectangle rectangle = new Rectangle(1,1,1,1,Color.BLACK);
		for (int i = 0; i<10; i++)
		{
			oval.randomize();
			g.setColor(oval.getColor());
			g.fillOval(oval.getX(), oval.getY(), oval.getW(), oval.getH());

			rectangle.randomize();
			g.setColor(rectangle.getColor());
			g.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getH(), rectangle.getW());
		}
	}

	public static void main(String[] args) {
		new DrawShapes();
	}
}
