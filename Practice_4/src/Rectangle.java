public class Rectangle extends Shape {
	protected double width, length;

	Rectangle() {
	}

	Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double getArea() {
		return width * length;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + length);
	}

	@Override
	public String toString() {
		return "Rectangle parameters:\nwidth = " + width + "\nlength" + length + "\ncolor = " + color + "\n filled = " + filled;
	}
}
