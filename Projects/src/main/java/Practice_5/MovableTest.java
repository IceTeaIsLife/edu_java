package Practice_5;

public class MovableTest {
	public static void main(String[] args) {
		MovablePoint movablePoint = new MovablePoint(0, 0, 1, 1);
		System.out.println(movablePoint.toString());
		movablePoint.moveRight();
		System.out.println(movablePoint.toString());

		MovableCircle movableCircle = new MovableCircle(0, 0, 2, 2, 1);
		System.out.println(movableCircle.toString());
		movableCircle.moveDown();
		System.out.println(movableCircle.toString());
	}
}
