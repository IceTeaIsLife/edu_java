package Practice_6;
import java.util.Scanner;
public class SquareFieldTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Type in size of field");
		SquareField squareField = new SquareField(in.nextInt());
		squareField.printArray();
		squareField.findMaxPath();
		squareField.printArray();
		squareField.printMax();
	}

}