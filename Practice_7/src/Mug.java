public class Mug extends Dish {
	private int volume = 0;

	Mug(String material, int price, int volume) {
		super(material, price);
		this.setVolume(volume);
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return this.price;
	}

	@Override
	public String ToString() {
		return "This mug is made of " + this.getMaterial() + ", its price is " + this.getPrice() + " roubles and its volume is " + getVolume() + " milliliters";
	}
}
