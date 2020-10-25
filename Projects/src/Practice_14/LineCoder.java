package Practice_14;


import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineCoder {
	private int rulesNumber;

	public void typeRulesNumber() throws RulesNumberException {
		//System.out.println("Введите количество правил сокращения");
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
		//System.out.println("Введите строку, которую необходимо преобразовать");
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
