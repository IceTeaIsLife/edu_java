public abstract class Dish {
	private String material = null;
	protected int price = 0;

	Dish(String material, int price) {
		this.material = material;
		this.price = price;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public abstract void setPrice(int price);

	public abstract int getPrice();

	public abstract String ToString();
}
