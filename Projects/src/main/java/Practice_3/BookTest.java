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
