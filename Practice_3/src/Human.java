import java.util.Scanner;
public class Human {
	static Head head = new Head();
	static Hand hand = new Hand();
	static Leg leg = new Leg();

	public static void main(String[] args) {
		head.setHowMuch(1);
		hand.setHowMuch(2);
		leg.setHowMuch(2);
		System.out.println("Average human has " + head.getHowMuch() + " head, " + hand.getHowMuch() + " hands and " + leg.getHowMuch() + " legs");
	}
}
