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
