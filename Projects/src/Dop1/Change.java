package Dop1;

public class Change {
	public int searchChange(int sum, int coin) {				//sum - общая сумма
		if (sum == 0)
			return 1;
		if (sum < 0)
			return 0;
		switch (coin)
		{
			case 5:
			{
				return searchChange(sum - 5, 5) + searchChange(sum - 3, 3) + searchChange(sum - 1, 1);
			}
			case 3:
			{
				return searchChange(sum - 3, 3) + searchChange(sum - 1, 1);
			}
			case 1:
			{
				return searchChange(sum - 1, 1);
			}
			default:
				return 0;
		}
	}
}