package Practice_3;

public class Human {
	private Head head = new Head();
	private Hand hand = new Hand();
	private Leg leg = new Leg();

	public void createHuman()
	{
		head.setHowMuch(1);
		hand.setHowMuch(2);
		leg.setHowMuch(2);
		System.out.println("Average human has " + head.getHowMuch() + " head, " + hand.getHowMuch() + " hands and " + leg.getHowMuch() + " legs");
	}
}
