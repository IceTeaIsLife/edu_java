package Practice_6;

import java.util.stream.*;
import java.util.Arrays;

public class SquareField {
	private int num = 0;
	private Position position = new Position(0,0);
	private int array[][];//[][];// = new int[num][num];
	SquareField(int num)
	{
		int array[][] = new int[num][num];
		for (int i = 0; i < num; i++)
		{
			for (int j = 0; j < num; j++)
			{
				array[i][j] = -10 + (int) (Math.random() * 30);
			}
		}
		//for (int i = 0; i < num; i++)
		//{
		//	for (int j = 0; j < num; j++)
		//	{
		//		System.out.println(array[i][j]);
		//	}
		//}

		Stream.of(array).map(Arrays::toString).forEach(System.out::println);
	}
}
