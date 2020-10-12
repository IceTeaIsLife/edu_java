package Practice_11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {
	//static AtomicInteger totalSum = new AtomicInteger();
	static int totalSum;
	//static int[] arrTotalSum = new int[10];
	static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		for (int i=0;i<10;i++)									//считаем в 1 потоке
		{
			work(i, false);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("One thread:");
		System.out.println("total time: " + (endTime - startTime));
		System.out.println("total sum: " + totalSum + "\n");

		totalSum = 0;
		startTime = System.currentTimeMillis();
		ArrayList<Thread> threads = new ArrayList<>();				//неправильно считаем в нескольких потоках
		for (int i = 0; i < 10; i++){
			final int localI = i;
			Thread thread = new Thread(() -> work(localI, false));
			thread.start();
			threads.add(thread);
		}

		for (Thread t : threads) {
			t.join();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Multiple threads, but wrong:");
		System.out.println("total time: " + (endTime - startTime));
		System.out.println("total sum: " + totalSum + "\n");
		threads.clear();


		totalSum = 0;
		startTime = System.currentTimeMillis(); //считаем правильно в нескольких потоках
		for (int i = 0; i < 10; i++){
			final int localI = i;
			Thread thread = new Thread(() -> work(localI, true));
			thread.start();
			threads.add(thread);
		}

		for (Thread t : threads) {
			t.join();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Multiple threads, but properly:");
		System.out.println("total time: " + (endTime - startTime));
		System.out.println("total sum: " + totalSum + "\n");
	}

	private static void work(int i, boolean properly) {
		long startTime = System.currentTimeMillis();
		long result;
		if (properly) {
			result = doHardWorkProperly(i * 1000, 100_000_000);
		}
		else {
			result = doHardWork(i * 1000, 100_000_000);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(i + ": " + result + " | " + (endTime-startTime));
	}

	private static long doHardWork(int start, int count) {
		long a = 0;
		for (int i = 0; i < count; i++) {
			a += (start + i) * (start + i) * Math.sqrt(start + i);
			totalSum++;
		}
		return a;
	}

	private synchronized static long doHardWorkProperly(int start, int count) {
		long a = 0;
		for (int i = 0; i < count; i++) {
			a += (start + i) * (start + i) * Math.sqrt(start + i);
			totalSum++;
		}
		return a;
	}

}
