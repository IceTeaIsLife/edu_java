package Practice_3;

public class Human {
	private Head head = new Head();
	private Hand hand = new Hand();
	private Leg leg = new Leg();

	public void setHead(int howMuch) {
		this.head.setHowMuch(howMuch);
	}

	public void setHand(int howMuch) {
		this.hand.setHowMuch(howMuch);
	}

	public void setLeg(int howMuch) {
		this.leg.setHowMuch(howMuch);
	}

	@Override
	public String toString() {
		return "Human{" +
				"head=" + head +
				", hand=" + hand +
				", leg=" + leg +
				'}';
	}
}
