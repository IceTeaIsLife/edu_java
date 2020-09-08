public class Table extends Furniture {

	Table(String name, String material) {
		super(name, material);
	}

	@Override
	public String ToString() {
		return "This " + this.getName() + " is made of " + this.getMaterial();
	}
}
