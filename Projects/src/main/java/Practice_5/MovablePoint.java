package Practice_5;

public class MovablePoint implements Movable {
	private double x;
	private double y;
	private double xSpeed;
	private double ySpeed;

	MovablePoint(double x, double y, double xSpeed, double ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	@Override
	public String toString() {
		return "MovablePoint{" +
				"x=" + x +
				", y=" + y +
				", xSpeed=" + xSpeed +
				", ySpeed=" + ySpeed +
				'}';
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	@Override
	public void moveUp() {
		this.y += this.ySpeed;
	}

	@Override
	public void moveDown() {
		this.y -= this.ySpeed;
	}

	@Override
	public void moveLeft() {
		this.x -= this.xSpeed;
	}

	@Override
	public void moveRight() {
		this.x += this.xSpeed;
	}
}
