package Practice_10;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
	private float result = 0;

	public Calculator() {
		setTitle("Calculator");
		setSize(400, 400);

		JLabel label = new JLabel(String.format("%.0f", result));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Times New Roman", Font.BOLD, 40));

		JTextField fieldA = new JTextField("0");
		fieldA.setFont(new Font("Times New Roman", Font.BOLD, 40));
		fieldA.setHorizontalAlignment(SwingConstants.RIGHT);


		JTextField fieldB = new JTextField("0");
		fieldB.setFont(new Font("Times New Roman", Font.BOLD, 40));
		fieldB.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton plus = new JButton("+");
		plus.setFont(new Font("Times New Roman", Font.BOLD, 40));
		plus.addActionListener(
				action -> {
					try {
						result = Float.parseFloat(fieldA.getText()) + Float.parseFloat(fieldB.getText());
						label.setText(String.format("%.4f", result));
					} catch (Exception e) {
						label.setText("Error");
					}
				}
		);

		JButton minus = new JButton("-");
		minus.setFont(new Font("Times New Roman", Font.BOLD, 40));
		minus.addActionListener(
				action -> {
					try {
						result = Float.parseFloat(fieldA.getText()) - Float.parseFloat(fieldB.getText());
						label.setText(String.format("%.4f", result));
					} catch (Exception e) {
						label.setText("Error");
					}
				}
		);

		JButton multiplication = new JButton("*");
		multiplication.setFont(new Font("Times New Roman", Font.BOLD, 40));
		multiplication.addActionListener(
				action -> {
					try {
						result = Float.parseFloat(fieldA.getText()) * Float.parseFloat(fieldB.getText());
						label.setText(String.format("%.4f", result));
					} catch (Exception e) {
						label.setText("Error");
					}
				}
		);

		JButton division = new JButton("/");
		division.setFont(new Font("Times New Roman", Font.BOLD, 40));
		division.addActionListener(
				action -> {
					try {
						result = Float.parseFloat(fieldA.getText()) / Float.parseFloat(fieldB.getText());
						label.setText(String.format("%.4f", result));
					} catch (Exception e) {
						label.setText("Error");
					}
				}
		);


		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(4, 1);
		panel.setLayout(layout);
		panel.add(fieldA);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		buttonPanel.add(plus);
		buttonPanel.add(minus);
		buttonPanel.add(division);
		buttonPanel.add(multiplication);

		panel.add(buttonPanel);
		panel.add(fieldB);
		panel.add(label);
		add(panel);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
