package Practice_4;

public class Circle extends Shape {
	protected double radius;

	Circle() {
	}

	Circle(double radius) {
		this.radius = radius;
	}

	Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle{" +
				"radius=" + radius +
				", color='" + color + '\'' +
				", filled=" + filled +
				'}';
	}
}