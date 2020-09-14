package Practice_7;

public class Corgi extends Dog {
	Corgi(String name, int age) {
		super(name, age);
	}

	@Override
	public String ToString() {
		return "The corgi named " + this.getName() + " is age of " + this.getAge();
	}
}
