package Practice_7;

public class CorgiTest {
	public static void main(String[] args) {
		Corgi corgi = new Corgi("Iggy", 7);
		System.out.println(corgi.ToString());
		corgi.setName("Bob");
		corgi.setAge(6);
		System.out.println(corgi.ToString());
	}
}