package Practice_5;

public class MovablePoint extends Movable {
	protected int x;
	protected int y;
	protected int xSpeed;
	protected int ySpeed;

	MovablePoint(int x, int y, int xSpeed, int ySpeed) {
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