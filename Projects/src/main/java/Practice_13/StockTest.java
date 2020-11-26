package Practice_13;

import java.util.Scanner;

public class StockTest {
	public static void main(String[] args) {
		Stock stock = new Stock();
		try {
			int cells = Integer.parseInt(new Scanner(System.in).nextLine());
			stock.fillCells(cells);
		} catch (MyException myException) {
			System.out.println("You can't fill negative number of cells");
		} catch (NumberFormatException numberFormatException) {
			System.out.println("Something wrong");
		} finally {
			System.out.println(stock);
		}
		//throw new MyRuntimeException();
	}
}
