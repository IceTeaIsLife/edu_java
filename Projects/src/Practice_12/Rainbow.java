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
