package Practice_8;

import java.awt.Shape;
import java.awt.*;

public class Oval extends Shape {
	private int w = 0;
	private int h = 0;

	Oval(int x, int y, int w, int h, Color color) {
		super(x, y, color);
		this.w = w;
		this.h = h;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public void randomize() {
		this.x = 100 + (int) (Math.random() * 1080);
		this.y = 100 + (int) (Math.random() * 520);
		this.w = 10 + (int) (Math.random() * 80);
		this.h = 10 + (int) (Math.random() * 80);
		this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}
}
