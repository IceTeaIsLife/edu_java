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
