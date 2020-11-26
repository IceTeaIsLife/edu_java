package Practice_3;

import java.util.Scanner;

public class CircleTest {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		System.out.println("Radius of circle is " + circle.getRad());
		System.out.println("Type in new radius\n");
		Scanner in = new Scanner(System.in);
		circle.setRad(in.nextDouble());
		System.out.println("Now radius of circle is " + circle.getRad());
	}
}
