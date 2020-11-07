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
