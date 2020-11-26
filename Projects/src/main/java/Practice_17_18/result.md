####Change.java
```java
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
```
####ChangeTest.java
```java
package Dop1;

public class ChangeTest {
	public static void main(String[] args) {
		Change change = new Change();
		System.out.println(change.searchChange(40, 5));
	}
}
```
####DopThreads.java
```java
package DopThread;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class DopThreads {
	//static AtomicInteger totalSum = new AtomicInteger();
	static int totalSum;
	static int[] arrTotalSum = new int[4];
	static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		ArrayList<Thread> threads = new ArrayList<>();
		for (int i = 0; i <  4; i++){
			final int localI = i;
			Thread thread = new Thread(() -> work(localI));
			thread.start();
			threads.add(thread);
		}

		for (Thread t : threads) {
			t.join();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("total time: " + (endTime - startTime));
		for (int j=0; j<arrTotalSum.length; j++)
		{
			totalSum += arrTotalSum[j];
		}
		System.out.println("total sum: " + totalSum);
	}

	private static void work(int i) {
		long startTime = System.currentTimeMillis();
		long result = doHardWork(i * 1000, 100_000_000, i);
		long endTime = System.currentTimeMillis();
		System.out.println(i + ": " + result + " | " + (endTime-startTime));
	}

	private synchronized static long doHardWork(int start, int count, int j) {
		long a = 0;
		for (int i = 0; i < count; i++) {
			a += (start + i) * (start + i) * Math.sqrt(start + i);
			//lock.lock();
			//totalSum++;
			arrTotalSum[j]++;
			//totalSum.addAndGet(1);
			//lock.unlock();
		}
		return a;
	}
}
```
####Main.java
```java
package Practice_1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Ex1();
        Ex2(args);
        Ex3();
        Ex4();
        Ex5();
    }

    public static void Ex1() {
        System.out.println("_Ex1_");
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма элементов через for: " + sum);

        sum = 0;
        int i = 0;
        while (i < array.length) {
            sum += array[i];
            i++;
        }
        System.out.println("Сумма элементов через while: " + sum);

        sum = 0;
        do {
            i--;
            sum += array[i];
        } while (i > 0);
        System.out.println("Сумма элементов через do while: " + sum);
    }

    public static void Ex2(String[] args) {
        System.out.println("_Ex2_");
        for (int i = 0; i < args.length; i++)
            System.out.println("args[" + i + "] : " + args[i]);
    }

    public static void Ex3() {
        System.out.println("_Ex3_");
        for (float i = 1; i <= 10; i++) {
            float res = 1 / i;
            System.out.printf("%.3f \n", res);
        }
    }

    public static void Ex4() {
        System.out.println("_Ex4_");
        int[] array = new int[10];
        System.out.println("Math.random():");
        for (int i = 0; i < 10; i++) {
            array[i] = 1 + (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        Arrays.sort(array);
        System.out.println("\nSorted array:");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nRandom:");
        for (int i = 0; i < 10; i++) {
            Random n = new Random();
            array[i] = n.nextInt(10);
            System.out.print(array[i] + " ");
        }
        Arrays.sort(array);
        System.out.println("\nSorted array:");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void Ex5() {
        System.out.println("\n_Ex5_");
        int res = 1;
        for (int i = 1; i < 8; i++) {
            res += res * i;
        }
        System.out.print("Факториал 8 = " + res);
    }
}
```
####Calculator.java
```java
package Practice_10;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
	private float result = 0;

	public Calculator() {
		setTitle("Calculator");
		setSize(400, 400);

		JLabel label = new JLabel(String.format("%.0f", result));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Times New Roman", Font.BOLD, 40));

		JTextField fieldA = new JTextField("0");
		fieldA.setFont(new Font("Times New Roman", Font.BOLD, 40));
		fieldA.setHorizontalAlignment(SwingConstants.RIGHT);


		JTextField fieldB = new JTextField("0");
		fieldB.setFont(new Font("Times New Roman", Font.BOLD, 40));
		fieldB.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton plus = new JButton("+");
		plus.setFont(new Font("Times New Roman", Font.BOLD, 40));
		plus.addActionListener(
				action -> {
					try {
						result = Float.parseFloat(fieldA.getText()) + Float.parseFloat(fieldB.getText());
						label.setText(String.format("%.4f", result));
					} catch (Exception e) {
						label.setText("Error");
					}
				}
		);

		JButton minus = new JButton("-");
		minus.setFont(new Font("Times New Roman", Font.BOLD, 40));
		minus.addActionListener(
				action -> {
					try {
						result = Float.parseFloat(fieldA.getText()) - Float.parseFloat(fieldB.getText());
						label.setText(String.format("%.4f", result));
					} catch (Exception e) {
						label.setText("Error");
					}
				}
		);

		JButton multiplication = new JButton("*");
		multiplication.setFont(new Font("Times New Roman", Font.BOLD, 40));
		multiplication.addActionListener(
				action -> {
					try {
						result = Float.parseFloat(fieldA.getText()) * Float.parseFloat(fieldB.getText());
						label.setText(String.format("%.4f", result));
					} catch (Exception e) {
						label.setText("Error");
					}
				}
		);

		JButton division = new JButton("/");
		division.setFont(new Font("Times New Roman", Font.BOLD, 40));
		division.addActionListener(
				action -> {
					try {
						result = Float.parseFloat(fieldA.getText()) / Float.parseFloat(fieldB.getText());
						label.setText(String.format("%.4f", result));
					} catch (Exception e) {
						label.setText("Error");
					}
				}
		);


		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(4, 1);
		panel.setLayout(layout);
		panel.add(fieldA);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		buttonPanel.add(plus);
		buttonPanel.add(minus);
		buttonPanel.add(division);
		buttonPanel.add(multiplication);

		panel.add(buttonPanel);
		panel.add(fieldB);
		panel.add(label);
		add(panel);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
```
####CalculatorTest.java
```java
package Practice_10;

import javax.swing.*;

public class CalculatorTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Calculator calculator = new Calculator();
			calculator.setVisible(true);
		});
	}
}
```
####Threads.java
```java
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
```
####Rainbow.java
```java
package Practice_12;

public class Rainbow {
	private String line;

	public String paintLine(String line, RainbowColors color) {
		return color.getCurrentColor() + line;
	}

	Rainbow(String line) {
		this.line = line;
	}

	public String getLine() {
		return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public void createRainbow() {
		System.out.println(paintLine(line, RainbowColors.RED));
		System.out.println(paintLine(line, RainbowColors.YELLOW));
		System.out.println(paintLine(line, RainbowColors.GREEN));
		System.out.println(paintLine(line, RainbowColors.CYAN));
		System.out.println(paintLine(line, RainbowColors.BLUE));
		System.out.println(paintLine(line, RainbowColors.MAGENTA));
	}
}
```
####RainbowColors.java
```java
package Practice_12;

public enum RainbowColors {
	RED("\u001B[31m"),
	YELLOW("\u001B[33m"),
	GREEN("\u001B[32m"),
	CYAN("\u001B[36m"),
	BLUE("\u001B[34m"),
	MAGENTA("\u001B[35m"),
	RESET("\u001B[0m");

	private String currentColor;

	RainbowColors(String color) {
		this.currentColor = color;
	}

	public String getCurrentColor() {
		return currentColor;
	}


}
```
####RainbowTest.java
```java
package Practice_12;

public class RainbowTest {
	public static void main(String[] args) {
		Rainbow rainbow = new Rainbow("SampleText");
		rainbow.createRainbow();
	}
}
```
####MyException.java
```java
package Practice_13;

public class MyException extends RuntimeException{
}
```
####MyRuntimeException.java
```java
package Practice_13;

public class MyRuntimeException extends RuntimeException {
}
```
####Stock.java
```java
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
```
####StockTest.java
```java
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
```
####LineCoder.java
```java
package Practice_14;


import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineCoder {
	private int rulesNumber;

	public void typeRulesNumber() throws RulesNumberException {
		System.out.println("Введите количество правил сокращения");
		Scanner in = new Scanner(System.in);
		int rulesNumber = Integer.parseInt(in.nextLine());
		if ((rulesNumber > 300) || (rulesNumber < 1)) {
			throw new RulesNumberException();
		} else {
			this.rulesNumber = rulesNumber;
		}
	}

	public void tryTypeRulesNumber() {
		try {
			this.typeRulesNumber();
		} catch (RulesNumberException e) {
			System.out.println("Количество правил должно быть от 1 до 300 включительно");
			tryTypeRulesNumber();
		}
	}

	public String typeLine() throws LineLengthException {
		System.out.println("Введите строку, которую необходимо преобразовать");
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		if (line.length() > 100_000) {
			throw new LineLengthException();
		} else {
			return line;
		}
	}

	public String tryTypeLine() {
		String line = null;
		try {
			line = this.typeLine();
		} catch (LineLengthException e) {
			System.out.println("Максимальная длина строки - 100 000 символов");
			tryTypeLine();
		}
		return line;
	}


	public void runApp() {
		tryTypeRulesNumber();
		Pattern pattern = Pattern.compile("(?<toFind>\\w+) (?<replaceTo>\\w+)");
		Matcher matcher;

		String[] searchList = new String[rulesNumber];
		String[] replacementList = new String[rulesNumber];

		String[] searchListRegex = new String[rulesNumber];
		String[] replacementListRegex = new String[rulesNumber];
		String line;
		for (int i = 0; i < rulesNumber; i++) {

			line = (new Scanner(System.in)).nextLine();
			searchList[i] = line.split(" ")[0];
			replacementList[i] = line.split(" ")[1];

			matcher = pattern.matcher(line);
			if (matcher.find()) {
				searchListRegex[i] = matcher.group("toFind");
				replacementListRegex[i] = matcher.group("replaceTo");
			}
		}

		line = this.tryTypeLine();
		String lineRegex = line;
		System.out.println("Common result:");
		System.out.println(StringUtils.replaceEach(line, searchList, replacementList));
		System.out.println("Regex result:");
		System.out.println(StringUtils.replaceEach(lineRegex, searchListRegex, replacementListRegex));
	}
/*
	public void makeReplacements() {
		tryTypeRulesNumer();
		ArrayList<String> rules = new ArrayList<>();

		for (int i = 0; i < rulesNumber; i++) {
			rules.add((new Scanner(System.in)).nextLine());
		}

		Pattern pattern = Pattern.compile("(?<toFind>\\w+) (?<replaceTo>\\w+)");
		Matcher matcher;
		String line = this.tryTypeLine();
		String lineRegex = line;
		for (int i = 0; i < rulesNumber; i++) {
			line = line.replaceAll(rules.get(i).split(" ")[0], " " + rules.get(i).split(" ")[1] + " ");
			matcher = pattern.matcher(rules.get(i));
			if (matcher.find()) {
				lineRegex = lineRegex.replaceAll(matcher.group("toFind"), " " + matcher.group("replaceTo") + " ");
			}
		}
		System.out.println("Common result:");
		System.out.println(line.replaceAll(" ", ""));
		System.out.println("Regex result:");
		System.out.println(lineRegex.replaceAll(" ", ""));
	}*/
}
```
####LineCoderTest.java
```java
package Practice_14;

public class LineCoderTest {
	public static void main(String[] args) {
		LineCoder lineCoder = new LineCoder();
		//lineCoder.makeReplacements();
		lineCoder.runApp();
	}
}
```
####LineLengthException.java
```java
package Practice_14;

public class LineLengthException extends Exception {
}
```
####Main.java
```java
package Practice_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = Integer.parseInt(scanner.nextLine());
		Pattern pat = Pattern.compile("(?<rule>\\w+) (?<on>\\w+)");
		ArrayList <Matcher> matchers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			matchers.add(pat.matcher(scanner.nextLine()));
		}
		String line = scanner.next();
		StringBuffer buffer = new StringBuffer();
		HashMap<String, String> dict = new HashMap<String, String>();
		for (Matcher matcher:matchers) {
			if(matcher.find()) {
				buffer.append(matcher.group("rule"));
				if (matcher != matchers.get(count - 1)) {
					buffer.append("|");
				}
				dict.put(matcher.group("rule"), matcher.group("on"));
			}
		}
		Pattern pattern = Pattern.compile(buffer.toString());
		Matcher matcher = pattern.matcher(line);
		System.out.println(matcher);
		line =  matcher.replaceAll(var -> dict.get(var.group()));
		System.out.println(line);
	}
}
```
####RulesNumberException.java
```java
package Practice_14;

public class RulesNumberException extends Exception {
}
```
####Graph.java
```java
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
```
####GraphTest.java
```java
package Practice_15_16;

public class GraphTest {
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.runGraph();
	}
}
```
####Result.java
```java
package Practice_17_18;

import java.io.*;
import java.io.File;
import java.nio.file.Paths;

public class Result {
	String basePath = "src";
	String resultPath = basePath + "/Practice_17_18/result.md";

	public void runApp() {
		File file = new File(basePath);
		File result = new File(resultPath);
		if (result.exists()) {
			result.delete();
		}
		fileSearch(file);
	}

	public void readWriteFile(String filePath, String fileName) {
		try {
			try (
					BufferedReader reader = new BufferedReader(new FileReader(filePath));
					FileWriter writer = new FileWriter(resultPath, true)
			) {
				String line = reader.readLine();
				writer.write("####" + fileName + "\n");
				writer.write("```java\n");
				while (line != null) {
					writer.write(line);
					writer.write('\n');
					line = reader.readLine();
				}
				writer.write("```\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Incorrect file path");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileSearch(File file) {
		if (file.isDirectory()) {
			String[] list = file.list();
			for (String s : list) {
				fileSearch(new File(String.valueOf(Paths.get(file.getAbsolutePath(), s).toAbsolutePath())));
			}
		} else if (file.getAbsolutePath().endsWith(".java")) {
			readWriteFile(file.getAbsolutePath(), file.getName());
		}
	}

}
```
####ResultTest.java
```java
package Practice_17_18;

public class ResultTest {
	public static void main(String[] args) {
		Result copy = new Result();
		copy.runApp();
		//copy.readWriteFile();
	}
}
```
####Ball.java
```java
package Practice_2;

public class Ball {
    Ball(){}

}
```
####Book.java
```java
package Practice_2;

public class Book {
    Book() {}
}
```
####Dog.java
```java
package Practice_2;

public class Dog {
    private String name = null;
    private int age = 0;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int toHumanAge()
    {
        return this.age*7;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```
####DogKennel.java
```java
package Practice_2;

import java.util.ArrayList;
import java.util.List;

public class DogKennel {
	private int maxCapacity = 100;
	ArrayList<Dog> dogs = new ArrayList<Dog>();

	public void addDog(Dog dog)
	{
		dogs.add(dog);
	}
}
```
####DogKennelTest.java
```java
package Practice_2;
import java.util.Scanner;
public class DogKennelTest {
	public static void main(String[] args) {
		DogKennel dogKennel = new DogKennel();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			dogKennel.addDog(new Dog(in.next(), in.nextInt()));
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(dogKennel.dogs.get(i).toString());
		}
	}
}
```
####Shape.java
```java
package Practice_2;

public class Shape {

    Shape (){}
    public String ToString(){
        return null;
    }

    public static void main(String[] args) {

    }
}
```
####ShapeTest.java
```java
package Practice_2;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.ToString();
    }
}
```
####Book.java
```java
package Practice_3;

public class Book {
	private String author = null;
	private String title = null;
	private int year = 0;
	private String genre = null;
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getTitle()
	{
		return this.title;
	}
	public int getYear()
	{
		return this.year;
	}
	public String getGenre()
	{
		return this.genre;
	}
}
```
####BookTest.java
```java
package Practice_3;

public class BookTest {
	static Book book = new Book();

	public static void main(String[] args) {
		book.setAuthor("Howard Lovecraft");
		book.setTitle("The Call of Cthulhu");
		book.setYear(1928);
		book.setGenre("horror");
		System.out.println("\"" + book.getTitle() + "\" was written in the " + book.getGenre() + " genre by " + book.getAuthor() + ". It was first published in February " + book.getYear() + ".");
	}
}
```
####Circle.java
```java
package Practice_3;

public class Circle {
	private double radius = 0;
	Circle(double radius)
	{
		this.radius = radius;
	}
	public void setRad(double radius)
	{
		this.radius = radius;
	}
	public double getRad()
	{
		return radius;
	}
}
```
####CircleTest.java
```java
package Practice_3;

import java.util.Scanner;

public class CircleTest {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		System.out.println("Radius of circle is " + circle.getRad());
		System.out.println("Type in new radius\n");
		Scanner in = new Scanner(System.in);
		circle.setRad(in.nextDouble());
		System.out.println("Now radius of circle is " + circle.getRad());
	}
}
```
####Hand.java
```java
package Practice_3;

public class Hand {
	private int howMuch = 0;
	public void setHowMuch(int howMuch)
	{
		this.howMuch = howMuch;
	}
	public int getHowMuch()
	{
		return howMuch;
	}
}
```
####Head.java
```java
package Practice_3;

public class Head {
	private int howMuch = 0;
	public void setHowMuch(int howMuch)
	{
		this.howMuch = howMuch;
	}
	public int getHowMuch()
	{
		return howMuch;
	}
}
```
####Human.java
```java
package Practice_3;

public class Human {
	private Head head = new Head();
	private Hand hand = new Hand();
	private Leg leg = new Leg();

	public void setHead(int howMuch) {
		this.head.setHowMuch(howMuch);
	}

	public void setHand(int howMuch) {
		this.hand.setHowMuch(howMuch);
	}

	public void setLeg(int howMuch) {
		this.leg.setHowMuch(howMuch);
	}

	@Override
	public String toString() {
		return "Human{" +
				"head=" + head +
				", hand=" + hand +
				", leg=" + leg +
				'}';
	}
}
```
####HumanTest.java
```java
package Practice_3;

public class HumanTest {
	public static void main(String[] args) {
		Human human = new Human();
		human.setHead(1);
		human.setHand(2);
		human.setLeg(2);
	}
}
```
####Leg.java
```java
package Practice_3;

public class Leg {
	private int howMuch = 0;
	public void setHowMuch(int howMuch)
	{
		this.howMuch = howMuch;
	}
	public int getHowMuch()
	{
		return howMuch;
	}
}
```
####Circle.java
```java
package Practice_4;

public class Circle extends Shape {
	protected double radius;

	Circle() {
	}

	Circle(double radius) {
		this.radius = radius;
	}

	Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle{" +
				"radius=" + radius +
				", color='" + color + '\'' +
				", filled=" + filled +
				'}';
	}
}
```
####Rectangle.java
```java
package Practice_4;

public class Rectangle extends Shape {
	protected double width, length;

	Rectangle() {
	}

	Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double getArea() {
		return width * length;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + length);
	}

	@Override
	public String toString() {
		return "Rectangle{" +
				"width=" + width +
				", length=" + length +
				", color='" + color + '\'' +
				", filled=" + filled +
				'}';
	}
}
```
####Shape.java
```java
package Practice_4;

public abstract class Shape {
	protected String color = null;
	protected boolean filled;

	Shape() {
	}

	Shape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public abstract double getArea();

	public abstract double getPerimeter();

	public abstract String toString();
}
```
####Square.java
```java
package Practice_4;

public class Square extends Rectangle {
	Square() {
	}

	Square(double side) {
		super(side, side);
	}

	Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}

	public double getSide() {
		return this.width;
	}

	public void setSide(double side) {
		this.width = side;
	}

	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		super.setLength(width);
	}

	@Override
	public void setLength(double length) {
		super.setLength(length);
		super.setWidth(length);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
```
####Movable.java
```java
package Practice_5;

public interface Movable {
	void moveUp();

	void moveDown();

	void moveLeft();

	void moveRight();
}
```
####MovableCircle.java
```java
package Practice_5;

public class MovableCircle implements Movable {
	private int radius;
	private MovablePoint center;

	MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		this.center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "MovableCircle{" +
				"radius=" + radius +
				", center=" + center +
				'}';
	}

	@Override
	public void moveUp() {
		this.center.moveUp();
	}

	@Override
	public void moveDown() {
		this.center.moveDown();
	}

	@Override
	public void moveLeft() {
		this.center.moveLeft();
	}

	@Override
	public void moveRight() {
		this.center.moveRight();
	}
}
```
####MovablePoint.java
```java
package Practice_5;

public class MovablePoint implements Movable {
	private double x;
	private double y;
	private double xSpeed;
	private double ySpeed;

	MovablePoint(double x, double y, double xSpeed, double ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	@Override
	public String toString() {
		return "MovablePoint{" +
				"x=" + x +
				", y=" + y +
				", xSpeed=" + xSpeed +
				", ySpeed=" + ySpeed +
				'}';
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	@Override
	public void moveUp() {
		this.y += this.ySpeed;
	}

	@Override
	public void moveDown() {
		this.y -= this.ySpeed;
	}

	@Override
	public void moveLeft() {
		this.x -= this.xSpeed;
	}

	@Override
	public void moveRight() {
		this.x += this.xSpeed;
	}
}
```
####MovableRectangle.java
```java
package Practice_5;

public class MovableRectangle implements Movable {
	private MovablePoint topLeft;
	private MovablePoint bottomRight;

	MovableRectangle(double x1, double y1, double x2, double y2, double xSpeed, double ySpeed) {
		this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
		this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
	}

	public void setWidth(double width)
	{
		if (width > this.getWidth())								//можно еще сделать width - getWidth
		{
			this.topLeft.setX(this.topLeft.getX() - width/2);
			this.bottomRight.setX(this.bottomRight.getX() + width/2);
		}
		else if (width < this.getWidth())
		{
			this.topLeft.setX(this.topLeft.getX() + width/2);
			this.bottomRight.setX(this.bottomRight.getX() - width/2);
		}
	}

	public void setHeight(double height)
	{
		if (height > this.getHeight())
		{
			this.topLeft.setY(this.topLeft.getY() + height/2);
			this.bottomRight.setY(this.bottomRight.getY() - height/2);
		}
		else if (height < this.getHeight())
		{
			this.topLeft.setY(this.topLeft.getY() - height/2);
			this.bottomRight.setY(this.bottomRight.getY() + height/2);
		}
	}

	public double getWidth()
	{
		return Math.abs(topLeft.getX() - bottomRight.getX());
	}

	public double getHeight()
	{
		return Math.abs(topLeft.getY() - bottomRight.getY());
	}

	@Override
	public String toString() {
		return "MovableRectangle{" +
				"topLeft=" + topLeft +
				", bottomRight=" + bottomRight +
				'}';
	}

	@Override
	public void moveUp() {
		this.topLeft.moveUp();
		this.bottomRight.moveUp();
	}

	@Override
	public void moveDown() {
		this.topLeft.moveDown();
		this.bottomRight.moveDown();
	}

	@Override
	public void moveLeft() {
		this.topLeft.moveLeft();
		this.bottomRight.moveLeft();
	}

	@Override
	public void moveRight() {
		this.topLeft.moveRight();
		this.bottomRight.moveRight();
	}
}
```
####MovableTest.java
```java
package Practice_5;

public class MovableTest {
	public static void main(String[] args) {
		MovablePoint movablePoint = new MovablePoint(0, 0, 1, 1);
		System.out.println(movablePoint.toString());
		movablePoint.moveRight();
		System.out.println(movablePoint.toString());

		MovableCircle movableCircle = new MovableCircle(0, 0, 2, 2, 1);
		System.out.println(movableCircle.toString());
		movableCircle.moveDown();
		System.out.println(movableCircle.toString());
	}
}
```
####SquareField.java
```java
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
```
####SquareFieldTest.java
```java
package Practice_6;
import java.util.Scanner;
public class SquareFieldTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Type in size of field");
		SquareField squareField = new SquareField(in.nextInt());
		squareField.printArray();
		squareField.findMaxPath();
		squareField.printArray();
		squareField.printMax();
	}

}
```
####Company.java
```java
package Practice_78;

//import java.util.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
	private long income;
	//private List<Employee> Staff;
	private List<Employee> Operators = new ArrayList<Employee>();
	private List<Employee> Managers = new ArrayList<Employee>();
	private List<Employee> TopManagers = new ArrayList<Employee>();


	public void hire(Employee employee) {
		switch (employee.getEmployeePosition().getJobTitle()) {
			case "Operator": {
				Operators.add(employee);
				break;
			}
			case "Manager": {
				Managers.add(employee);
				break;
			}
			case "TopManager": {
				TopManagers.add(employee);
				break;
			}
		}
	}

	public void hireAll(Employee employee, Employee... employees) {
		hire(employee);
		for (Employee value : employees) {
			hire(value);
		}
	}

	public void fire(String position) {
		switch (position) {
			case "Operator": {
				Operators.remove(Operators.size() - 1);
				break;
			}
			case "Manager": {
				Managers.remove(Managers.size() - 1);
				break;
			}
			case "TopManager": {
				TopManagers.remove(TopManagers.size() - 1);
				break;
			}
		}
	}

	public void firePercents(int percents)                //метод "увольняет" сотрудников с самыми низкими зарпалатами, аргумент - процент от общего штата
	{
		int den = 100 / percents;

		Operators.sort(Comparator.comparing(Employee::getTotal).reversed());
		int fireNum = Operators.size() / den;
		for (int i = 0; i < fireNum; i++) {
			this.fire("Operator");
		}

		Managers.sort(Comparator.comparing(Employee::getTotal).reversed());
		fireNum = Managers.size() / den;
		for (int i = 0; i < fireNum; i++) {
			this.fire("Manager");
		}

		TopManagers.sort(Comparator.comparing(Employee::getTotal).reversed());
		fireNum = TopManagers.size() / den;
		for (int i = 0; i < fireNum; i++) {
			this.fire("TopManager");
		}

		System.out.println("Было уволено "+ percents + "% сотрудников");
	}

	public void workOneMonth() {			//метод начисления зарплаты сотрудникам за "месяц" работы
		for (Employee manager : Managers) {
			manager.setTotal(manager.getEmployeePosition().calcSalary(manager.getSalary()));
			income += (manager.getTotal() - manager.getSalary()) * 20;			//достаем из Manager количество заработанных денег для компании
		}
		for (Employee operator : Operators) {
			operator.setTotal(operator.getEmployeePosition().calcSalary(operator.getSalary()));
		}
		for (Employee topManger : TopManagers) {
			topManger.setTotal(topManger.getEmployeePosition().calcSalary(topManger.getSalary()));
		}
	}

	public double getIncome() {
		return income;
	}

	public List<Employee> getTopSalaryStaff(int count) {
		if (count > 0) {
			List<Employee> Staff = new ArrayList<Employee>();	//создаем временный список всех сотрудников
			Staff.addAll(Operators);
			Staff.addAll(Managers);
			Staff.addAll(TopManagers);
			if (count <= Staff.size()) {
				Staff.sort(Comparator.comparing(Employee::getTotal).reversed());	//сортировка по полю total по убыванию
				return Staff.subList(0, count);
			}
			return null;
		}
		return null;
	}

	public List<Employee> getLowestSalaryStaff(int count) {
		if (count > 0) {
			List<Employee> Staff = new ArrayList<Employee>();
			Staff.addAll(Operators);
			Staff.addAll(Managers);
			Staff.addAll(TopManagers);
			if (count <= Staff.size()) {
				Staff.sort(Comparator.comparing(Employee::getTotal));	//сортировка по полю total по возрастанию
				return Staff.subList(0, count);
			}
			return null;
		}
		return null;
	}
}
```
####CompanyTest.java
```java
package Practice_78;

import java.util.Scanner;

public class CompanyTest {
	public static void main(String[] args) {
		Company company = new Company();
		for (int i = 0; i < 60; i++) {
			company.hireAll(new Employee("Oper", "Ator", (int) (40000 + Math.random() * 10000), new Operator()),
					new Employee("Oper", "Ator", (int) (40000 + Math.random() * 10000), new Operator()),
					new Employee("Oper", "Ator", (int) (40000 + Math.random() * 10000), new Operator()));
		}
		for (int i = 0; i < 40; i++) {
			company.hireAll(new Employee("Man", "Ager", (int) (80000 + Math.random() * 10000), new Manager()),
					new Employee("Man", "Ager", (int) (80000 + Math.random() * 10000), new Manager()));
		}
		for (int i = 0; i < 10; i++) {
			company.hire(new Employee("Top", "Manager", (int) (90000 + Math.random() * 10000), new TopManager(company)));
		}

		company.workOneMonth();    //компания работает 1 месяц

		System.out.println("Топ самых высоких зарплат");
		for (Employee employee : company.getTopSalaryStaff(10))  //выводим топ самых высоких зарплат
		{
			System.out.println((int) employee.getTotal() + " руб.");
		}

		System.out.println("\nТоп самых низких зарплат");
		for (Employee employee : company.getLowestSalaryStaff(30))    //выводим топ самых низких зарплат
		{
			System.out.println((int) employee.getTotal() + " руб.");
		}

		company.firePercents(50);	//уволняем 50% сотрудников

		System.out.println("Топ самых высоких зарплат");
		for (Employee employee : company.getTopSalaryStaff(10))  //выводим топ самых высоких зарплат
		{
			System.out.println((int) employee.getTotal() + " руб.");
		}

		System.out.println("\nТоп самых низких зарплат");
		for (Employee employee : company.getLowestSalaryStaff(30))    //выводим топ самых низких зарплат
		{
			System.out.println((int) employee.getTotal() + " руб.");
		}

		if (true) {                                                    //for debug
			Scanner in = new Scanner(System.in);
			in.next();
		}
	}
}
```
####Employee.java
```java
package Practice_78;

public class Employee {
	private String name;
	private String surname;
	private double salary;
	private double total;
	private EmployeePosition employeePosition;

	public Employee(String name, String surname, double salary, EmployeePosition employeePosition) {
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.employeePosition = employeePosition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeePosition getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(EmployeePosition employeePosition) {
		this.employeePosition = employeePosition;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
}
```
####EmployeePosition.java
```java
package Practice_78;

public interface EmployeePosition {
	String getJobTitle();

	double calcSalary(double baseSalary);
}
```
####Manager.java
```java
package Practice_78;

public class Manager implements EmployeePosition {

	@Override
	public String getJobTitle() {
		return "Manager";
	}

	@Override
	public double calcSalary(double baseSalary) {
		return baseSalary + 0.05 * (int) (115000 + Math.random() * 25000);
	}
}
```
####Operator.java
```java
package Practice_78;

public class Operator implements EmployeePosition {

	@Override
	public String getJobTitle() {
		return "Operator";
	}

	@Override
	public double calcSalary(double baseSalary) {
		return baseSalary;
	}
}
```
####TopManager.java
```java
package Practice_78;

public class TopManager implements EmployeePosition {
	private Company company;

	TopManager(Company company) {
		this.company = company;
	}

	@Override
	public String getJobTitle() {
		return "TopManager";
	}

	@Override
	public double calcSalary(double baseSalary) {
		if (company.getIncome() > 10000000)
			return baseSalary * 2.5;
		else
			return baseSalary;
	}
}
```
####Company.java
```java
package Practice_9;

import java.util.ArrayList;

public class Company {
	private final ArrayList<Employee> employees;

	public Company() {
		employees = new ArrayList<>();
	}

	public void hire(Employee employee) {
		employees.add(employee);
	}

	public void hireAll(Employee employee, Employee... employees) {
		hire(employee);
		for (Employee empl : employees) {
			hire(empl);
		}
	}

	public void fire() {
		employees.remove(employees.size() - 1);
	}

	public void HandleEmployees(EmployeeSelector selector, EmployeeHandler handler) {
		int count = 0;
		for (Employee employee : employees) {
			if (selector.isNeedEmployee(employee)) {
				handler.handleEmployee(employee, count);
				count++;
			}
		}
		System.out.println(count);
	}

	public void firePercents(int percents) {
		int den = 100 / percents;

		int fireNum = employees.size() / den;
		for (int i = 0; i < fireNum; i++) {
			this.fire();
		}

		System.out.println("Было уволено " + percents + "% сотрудников");
	}

	@Override
	public String toString() {
		return "Company{" +
				"employees=" + employees +
				'}';
	}
}
```
####CompanyTest.java
```java
package Practice_9;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class CompanyTest {

	public static int randBetween(int min, int max) {
		return min + (int) Math.round(Math.random() * (max - min));
	}

	public static GregorianCalendar randDateOfBirth(GregorianCalendar gregorianCalendar) {
		int year = randBetween(1970, 2000);
		gregorianCalendar.set(gregorianCalendar.YEAR, year);
		//int month = randBetween(1,12);
		//gregorianCalendar.set(gregorianCalendar.MONTH, month);
		int dayOfYear = randBetween(1, gregorianCalendar.getActualMaximum(gregorianCalendar.DAY_OF_YEAR));
		gregorianCalendar.set(gregorianCalendar.DAY_OF_YEAR, dayOfYear);
		//System.out.println(gregorianCalendar.get(gregorianCalendar.YEAR) + "-" + (gregorianCalendar.get(gregorianCalendar.MONTH) + 1) + "-" + gregorianCalendar.get(gregorianCalendar.DAY_OF_MONTH));
		return gregorianCalendar;
	}

	public static void doSome(Employee employee, int index) {
		System.out.println("=======" + index + "=======");
		System.out.println(employee);
	}

	public static void main(String[] args) {
		Company company = new Company();
		long number = 8927000000L;

		for (int i = 0; i < 20; i++) {
			company.hireAll(new Employee("Ooga",
							"Booga",
							randDateOfBirth(new GregorianCalendar()), "Detroit",
							String.valueOf(number + randBetween(0, 999999)),
							randBetween(50000, 70000)),
					new Employee("Git",
							"Damoney",
							randDateOfBirth(new GregorianCalendar()), "Detroit",
							String.valueOf(number + randBetween(0, 999999)),
							randBetween(50000, 70000))
			);
		}

		company.HandleEmployees(new SalarySelector(60000, 65000),
				(employee, index) -> System.out.println("employee " + index + ":" + employee));


		int year = 1980;
		company.HandleEmployees(new EmployeeSelector() {
									@Override
									public boolean isNeedEmployee(Employee employee) {
										return employee.getDateOfBirth().get(employee.getDateOfBirth().YEAR) > year;
									}
								}, new EmployeeHandler() {
									@Override
									public void handleEmployee(Employee employee, int index) {
										System.out.println("=======" + index + "=======");
										System.out.println(employee);
									}
								}
		);

		company.HandleEmployees(employee -> employee.getSurname() == "Booga", CompanyTest::doSome);

		Scanner in = new Scanner(System.in);
		in.next();

	}

}
```
####Employee.java
```java
package Practice_9;

import java.util.GregorianCalendar;

public class Employee {
	private String name;
	private String surname;
	private final GregorianCalendar dateOfBirth;
	private String location;
	private String number;
	private double salary;

	public Employee(String name, String surname, GregorianCalendar dateOfBirth, String location, String number, double salary) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.location = location;
		this.number = number;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
```
####EmployeeHandler.java
```java
package Practice_9;

public interface EmployeeHandler {
	void handleEmployee(Employee employee, int index);
}
```
####EmployeeSelector.java
```java
package Practice_9;

public interface EmployeeSelector {
	boolean isNeedEmployee(Employee employee);
}
```
####SalarySelector.java
```java
package Practice_9;

public class SalarySelector implements  EmployeeSelector{
	private double salaryMin;
	private double salaryMax;

	public SalarySelector(double salaryMin, double salaryMax) {
		this.salaryMin = salaryMin;
		this.salaryMax = salaryMax;
	}


	@Override
	public boolean isNeedEmployee(Employee employee) {
		return employee.getSalary() >= salaryMin && employee.getSalary() <= salaryMax;
	}
}
```
