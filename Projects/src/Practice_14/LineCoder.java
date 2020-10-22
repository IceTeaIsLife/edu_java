package Practice_14;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineCoder {
	private int rulesNumber;

	public void setRulesNumber(int rulesNumber) {
		this.rulesNumber = rulesNumber;
	}

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

	public void tryTypeRulesNumer() {
		try {
			this.typeRulesNumber();
		} catch (RulesNumberException e) {
			System.out.println("Количество правил должно быть от 1 до 300 включительно");
			tryTypeRulesNumer();
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

	public String makeReplacements(String line, ArrayList<String> rules) {
		for (int i = 0; i < rulesNumber; i++) {
			line = line.replaceAll(rules.get(rules.size() - 2 - i * 2), " " + rules.get(rules.size() - 1 - i * 2) + " ");
		}

		return line.replaceAll(" ", "");
	}

	public void runApp() {                    //без регулярных выражений
		tryTypeRulesNumer();
		ArrayList<String> rules = new ArrayList<String>();
		String line;
		for (int i = 0; i < rulesNumber; i++) {
			line = (new Scanner(System.in)).nextLine();
			rules.add(line.split(" ")[0]);
			rules.add(line.split(" ")[1]);
		}

		line = makeReplacements(this.tryTypeLine(), rules);
		System.out.println(line);
	}

	public void runWithRegex()                        //с регулярными выражениями
	{
		System.out.println("Running with regex...");
		tryTypeRulesNumer();

		ArrayList<String> rules = new ArrayList<String>();
		Pattern pattern = Pattern.compile("(?<toFind>\\w+) (?<replaceTo>\\w+)");
		Matcher matcher;
		for (int i = 0; i < rulesNumber; i++) {
			matcher = pattern.matcher((new Scanner(System.in)).nextLine());
			if (matcher.find()) {
				rules.add(matcher.group("toFind"));
				rules.add(matcher.group("replaceTo"));
			}
		}

		String line = makeReplacements(this.tryTypeLine(), rules);
		System.out.println(line);
	}
}
