package Practice_6;

import java.util.stream.*;
import java.util.Arrays;

public class SquareField {
	private int size;
	private int[][] array;

	SquareField(int size) {
		this.size = size;
		array = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = -10 + (int) (Math.random() * 30);
			}
		}
	}

	public void findMaxPath() {
		for (int i = 1; i < size; i++) {
			array[0][i] = array[0][i - 1] + array[0][i];
			array[i][0] = array[i - 1][0] + array[i][0];
		}
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				array[i][j] = Math.max(array[i][j - 1], array[i - 1][j]) + array[i][j];
			}
		}
	}

	public void printArray() {
		Stream.of(array).map(Arrays::toString).forEach(System.out::println);
		System.out.println("===========================================================================================================");
	}

	public void printMax() {
		System.out.println("Maximum points = " + array[size - 1][size - 1]);
	}

}
