package Practice_8;

import java.awt.*;

public class Shape {
	protected Color color = new Color(0, 0, 0);
	protected int x = 0;
	protected int y = 0;

	Shape(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
}
