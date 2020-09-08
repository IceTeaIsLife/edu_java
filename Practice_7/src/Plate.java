public class Plate extends Dish {
	private int diameter = 0;

	Plate(String material, int price, int diameter) {
		super(material, price);
		this.setDiameter(diameter);
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getDiameter() {
		return diameter;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return this.price;
	}
	public String ToString() {
		return "This plate is made of " + this.getMaterial() + ", its price is " + this.getPrice() + " roubles and its diameter is " + getDiameter() + " centimeters";
	}
}
