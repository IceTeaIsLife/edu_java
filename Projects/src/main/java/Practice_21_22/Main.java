package Practice_21_22;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What do you want to work with?\n" +
				"1 - with server\n" +
				"2 - with local file");
		switch (in.nextInt())
		{
			case 1:{
				ServerApp serverApp = new ServerApp();
				serverApp.runApp();
				break;
			}
			case 2:{
				FileApp fileApp = new FileApp();
				fileApp.runApp();
				break;
			}
		}
	}
}
