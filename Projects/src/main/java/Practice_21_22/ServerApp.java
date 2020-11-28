package Practice_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ServerApp implements ItemsStore {
	static HttpClient httpClient = HttpClient.newHttpClient();
	static Gson gson = new Gson();
	static Scanner in = new Scanner(System.in);
	static String address = "http://80.87.199.76:3000/objects";

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
			switch (in.nextInt()) {
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
					int id = Integer.parseInt(in.nextLine());
					System.out.println("type in data of new item");
					String data = in.nextLine();
					System.out.println("type in isGood of new item");
					boolean isGood = in.nextBoolean();
					System.out.println("type in description of new item");
					String description = in.nextLine();
					addItem(new Item(id, data, isGood, description));
					System.out.println("item_+ " + id + " is added");
					break;
				}
				case 4: {
					System.out.println("type in id of item you wanna edit");
					int id = Integer.parseInt(in.nextLine());
					Item item = get(id);
					System.out.println("choose field to edit from list:\n" +
							"1 - id\n" +
							"2 - data\n" +
							"3 - isGood\n" +
							"4 - description");
					int field = Integer.parseInt(in.nextLine());
					System.out.println("type in new field");
					switch (field) {
						case 1: {
							item.setId(Integer.parseInt(in.nextLine()));
							break;
						}
						case 2: {
							item.setData(in.nextLine());
							break;
						}
						case 3: {
							item.setGood(in.nextBoolean());
							break;
						}
						case 4: {
							item.setDescription(in.nextLine());
							break;
						}
					}
					editItem(id, item);
					System.out.println(field + " item_" + id + " is edited");
					break;
				}
				case 5: {
					System.out.println("type in id of item to delete");
					int id = Integer.parseInt(in.nextLine());
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
		List<Item> items = null;
		Type collectionType = new TypeToken<Collection<Item>>() {
		}.getType();
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create(address))
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			items = gson.fromJson(response.body(), collectionType);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item get(int id) {
		Item item = null;
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create(address + id))
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			item = gson.fromJson(response.body(), Item.class);
			System.out.println(gson.fromJson(response.body(), Item.class));
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Item addItem(Item item) {
		try {
			String body = gson.toJson(item);
			HttpRequest request = HttpRequest.newBuilder()
					.POST(HttpRequest.BodyPublishers.ofString(body))
					.uri(URI.create(address))
					.setHeader("Content-Type", "application/json")
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return item;
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Item editItem(int id, Item item) {
		try {
			String body = gson.toJson(item);
			HttpRequest request = HttpRequest.newBuilder()
					.PUT(HttpRequest.BodyPublishers.ofString(body))
					.uri(URI.create(address + id))
					.setHeader("Content-Type", "application/json")
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return item;
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteItem(int id) {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.DELETE()
					.uri(URI.create(address + id))
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
