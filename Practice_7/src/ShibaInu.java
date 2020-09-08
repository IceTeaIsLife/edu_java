public class ShibaInu extends Dog{
	ShibaInu(String name, int age) {
		super(name, age);
	}

	@Override
	public String ToString() {
		return "The shiba inu named " + this.getName() + " is age of " + this.getAge();
	}
}
