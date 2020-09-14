package Practice_7;

import java.util.Scanner;

public class FurnitureShop {
	private static int currentCash = 300;
	private static Chair chair = new Chair(10, 30);
	private static Table table = new Table(6, 80);
	private static Scanner in = new Scanner(System.in);

	public static void printStock() {
		System.out.println("Our stock:");
		System.out.println("Chairs (" + chair.getPrice() + " bucks):");
		System.out.println(chair.getAmount() + " left");

		System.out.println("Tables (" + table.getPrice() + " bucks):");
		System.out.println(table.getAmount() + " left");
	}

	public static void purchaseProcess(String answer) {
		while (!answer.equals("Exit")) {
			if (answer.equals("Chair") && (chair.getAmount() > 0)) {
				if (currentCash >= chair.getPrice()) {
					chair.purchaseItem();
					currentCash -= chair.getPrice();
				} else
					System.out.println("You don't have enough money");
			} else if (answer.equals("Chair")) {
				System.out.println("Sorry, chairs sold out");
			}
			if (answer.equals("Table") && (table.getAmount() > 0)) {
				if (currentCash >= table.getPrice()) {
					table.purchaseItem();
					currentCash -= table.getPrice();
				} else
					System.out.println("You don't have enough money");
			} else if (answer.equals("Table")) {
				System.out.println("Sorry, tables sold out");
			}
			if (!answer.equals("Chair") && !answer.equals("Table")) {
				System.out.println("Sorry, we don't have that");
			}
			System.out.println("Wanna buy something?");
			System.out.println("*you have " + currentCash + " bucks in your pocket*");
			printStock();
			answer = in.next();
		}
	}

	public static void mainProcess()
	{
		System.out.println("Welcome to the shop, buddy!\n");
		System.out.println("*you have " + currentCash + " bucks in your pocket*");
		System.out.println("*type \"Exit\" to leave the shop*");
		printStock();
		System.out.println("Wanna buy something?");
		String answer = in.next();
		purchaseProcess(answer);
		System.out.println("See you next time!");
	}

	public static void main(String[] args) {
		mainProcess();
	}
}
