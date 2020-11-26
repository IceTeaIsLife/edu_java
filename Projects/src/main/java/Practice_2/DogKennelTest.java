package Practice_2;
import java.util.Scanner;
public class DogKennelTest {
	public static void main(String[] args) {
		DogKennel dogKennel = new DogKennel();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			dogKennel.addDog(new Dog(in.next(), in.nextInt()));
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(dogKennel.dogs.get(i).toString());
		}
	}
}