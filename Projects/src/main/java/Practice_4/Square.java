package Practice_4;

public class Square extends Rectangle {
	Square() {
	}

	Square(double side) {
		super(side, side);
	}

	Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}

	public double getSide() {
		return this.width;
	}

	public void setSide(double side) {
		this.width = side;
	}

	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		super.setLength(width);
	}

	@Override
	public void setLength(double length) {
		super.setLength(length);
		super.setWidth(length);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
