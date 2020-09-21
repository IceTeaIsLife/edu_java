package Practice_5;

public class MovableRectangle implements Movable {
	private MovablePoint topLeft;
	private MovablePoint bottomRight;

	MovableRectangle(double x1, double y1, double x2, double y2, double xSpeed, double ySpeed) {
		this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
		this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
	}

	public void setWidth(double width)
	{
		if (width > this.getWidth())								//можно еще сделать width - getWidth
		{
			this.topLeft.setX(this.topLeft.getX() - width/2);
			this.bottomRight.setX(this.bottomRight.getX() + width/2);
		}
		else if (width < this.getWidth())
		{
			this.topLeft.setX(this.topLeft.getX() + width/2);
			this.bottomRight.setX(this.bottomRight.getX() - width/2);
		}
	}

	public void setHeight(double height)
	{
		if (height > this.getHeight())
		{
			this.topLeft.setY(this.topLeft.getY() + height/2);
			this.bottomRight.setY(this.bottomRight.getY() - height/2);
		}
		else if (height < this.getHeight())
		{
			this.topLeft.setY(this.topLeft.getY() - height/2);
			this.bottomRight.setY(this.bottomRight.getY() + height/2);
		}
	}

	public double getWidth()
	{
		return Math.abs(topLeft.getX() - bottomRight.getX());
	}

	public double getHeight()
	{
		return Math.abs(topLeft.getY() - bottomRight.getY());
	}

	@Override
	public String toString() {
		return "MovableRectangle{" +
				"topLeft=" + topLeft +
				", bottomRight=" + bottomRight +
				'}';
	}

	@Override
	public void moveUp() {
		this.topLeft.moveUp();
		this.bottomRight.moveUp();
	}

	@Override
	public void moveDown() {
		this.topLeft.moveDown();
		this.bottomRight.moveDown();
	}

	@Override
	public void moveLeft() {
		this.topLeft.moveLeft();
		this.bottomRight.moveLeft();
	}

	@Override
	public void moveRight() {
		this.topLeft.moveRight();
		this.bottomRight.moveRight();
	}
}
