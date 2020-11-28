package Practice_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FileApp implements ItemsStore {
	static Gson gson = new Gson();
	static Scanner in = new Scanner(System.in);
	String path = "src/main/java/Practice_21_22/file.json";
	private File file = new File(path);

	public void runApp() {
		boolean run = true;
		while (run) {
			System.out.println("Choose action\n" +
					"1 - get all items\n" +
					"2 - get item by id\n" +
					"3 - add item\n" +
					"4 - edit item\n" +
					"5 - delete item\n" +
					"6 - exit");
			int answer = in.nextInt();
			switch (answer) {
				case 1: {
					System.out.println(getAll());
					break;
				}
				case 2: {
					System.out.println("type in id of item");
					System.out.println(get(Integer.parseInt(in.nextLine())).toString());
					break;
				}
				case 3: {
					System.out.println("type in id of new item");
					int id = in.nextInt();
					System.out.println("type in data of new item");
					String data = new Scanner(System.in).nextLine();
					System.out.println("type in isGood of new item");
					boolean isGood = in.nextBoolean();
					System.out.println("type in description of new item");
					String description = new Scanner(System.in).nextLine();
					addItem(new Item(id, data, isGood, description));
					System.out.println("item_" + id + " is added");
					break;
				}
				case 4: {
					System.out.println("type in id of item you wanna edit");
					int id = in.nextInt();
					Item item = get(id);
					System.out.println("choose field to edit from list:\n" +
							"1 - id\n" +
							"2 - data\n" +
							"3 - isGood\n" +
							"4 - description");
					int field = in.nextInt();
					System.out.println("type in new field");
					switch (field) {
						case 1: {
							item.setId(in.nextInt());
							break;
						}
						case 2: {
							item.setData(new Scanner(System.in).nextLine());
							break;
						}
						case 3: {
							item.setGood(in.nextBoolean());
							break;
						}
						case 4: {
							item.setDescription(new Scanner(System.in).nextLine());
							break;
						}
					}
					editItem(id, item);
					System.out.println(field + " item_" + id + " is edited");
					break;
				}
				case 5: {
					System.out.println("type in id of item to delete");
					int id = in.nextInt();
					deleteItem(id);
					System.out.println("item_+ " + id + " is added");
					break;
				}
				case 6: {
					run = false;
					break;
				}
			}
		}
	}

	@Override
	public List<Item> getAll() {
		String line, result = "";
		List<Item> items = null;
		Type collectionType = new TypeToken<Collection<Item>>() {
		}.getType();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine())!= null) {
				result += line + "\n";
				line = reader.readLine();
			}
			items = gson.fromJson(result, collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item get(int id) {
		for (Item item : getAll())
		{
			if (id == item.getId())
			{
				return item;
			}
		}
		return null;
	}

	@Override
	public Item addItem(Item item) {
		try
		{
			FileWriter writer = new FileWriter(file, true);
			if(item.getId() != 1) {
				writer.write(",\n");
			}
			writer.write(gson.toJson(item)
					.replace(",", ",\n    ")
					.replace("{", "{\n    ")
					.replace("}", "\n}"))
			;
			writer.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Item editItem(int id, Item item) {
		deleteItem(id);
		addItem(item);
		return item;
	}

	@Override
	public void deleteItem(int id) {
		List<Item> items = getAll();
		items.remove(id);
		for (Item item:
			 items) {
			addItem(item);
		}
	}
}
