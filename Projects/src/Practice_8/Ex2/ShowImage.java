package Practice_8.Ex2;

import javax.swing.*;
import java.awt.*;

public class ShowImage extends JFrame {

	private ImageIcon image;
	private JLabel label;

	ShowImage(String path) {
		setLayout(new FlowLayout());

		image = new ImageIcon(getClass().getResource(path));
		label = new JLabel(image);
		add(label);
	}

	public static void main(String[] args) {
		ShowImage img = new ShowImage(args[0]);
		img.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		img.setVisible(true);
		img.pack();
	}
}
