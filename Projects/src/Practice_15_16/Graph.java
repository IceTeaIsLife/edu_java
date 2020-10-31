package Practice_15_16;

import java.util.Scanner;

public class Graph {
	private int currentState;    //1..6

	public void action(int num) {
		switch (num) {
			case 1: {
				System.out.println("create_project");
				break;
			}
			case 2: {
				System.out.println("add_library");
				break;
			}
			case 3: {
				System.out.println("restart");
				break;
			}
			case 4: {
				System.out.println("test");
				break;
			}
			case 5: {
				System.out.println("deploy");
				break;
			}
			case 6: {
				System.out.println("drop_db");
				break;
			}
		}
	}

	public void stateSelector(int output) {
		switch (currentState) {
			case 1: {
				if (output == 0) {
					currentState = 2;
					action(1);
				}
				else {
					currentState = 5;
					action(2);
				}
				break;
			}
			case 2: {
				if (output == 0) {
					currentState = 3;
					action(4);
				}
				else {
					currentState = 4;
					action(6);
				}
				break;
			}
			case 3: {
				if (output == 0) {
					currentState = 4;
					action(6);
				}
				else {
					currentState = 5;
					action(2);
				}
				break;
			}
			case 4: {
				if (output == 0) {
					currentState = 3;
					action(3);
				}
				else {
					currentState = 5;
					action(5);
				}
				break;
			}
			case 5: {
				if (output == 0) {
					currentState = 1;
					action(5);
				}
				else {
					currentState = 3;
					action(3);
				}
				break;
			}
		}
	}

	public void runGraph()
	{
		Scanner in = new Scanner(System.in);
		currentState = 1;
		int output = in.nextInt();
		while (output != -1)
		{
			stateSelector(output);
			output = in.nextInt();
		}
	}
}
