package Practice_10;

import javax.swing.*;

public class CalculatorTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Calculator calculator = new Calculator();
			calculator.setVisible(true);
		});
	}
}
