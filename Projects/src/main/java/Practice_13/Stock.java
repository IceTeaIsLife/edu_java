package Practice_13;

public class Stock {
	private int cells;

	public void fillCells(int cells) throws MyException {
		if (cells < 0) {
			throw new MyException();
		} else this.cells += cells;
	}

	@Override
	public String toString() {
		return "Stock{" +
				"filledCells=" + cells +
				'}';
	}
}
