import java.util.Scanner;

public class DogKennel {
	private int maxCapacity = 7;
	private Dog[] doge = new Dog[maxCapacity];
	private Scanner in = new Scanner(System.in);

	public void addDogs() {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < maxCapacity; i++) {
			doge[i] = new Dog(in.next(), in.nextInt());
			System.out.println(doge[i].toString());
		}
	}
}
