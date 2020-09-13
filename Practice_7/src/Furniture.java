public abstract class Furniture {
	private int amount;
	private int price;
	Furniture(int amount, int price)
	{
		this.amount = amount;
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void purchaseItem()
	{
		this.amount--;
	}

	@Override
	public String toString() {
		return "Furniture{" +
				"amount=" + amount +
				", price=" + price +
				'}';
	}
}
