package Practice_7;

public class ShibaInuTest {
	public static void main(String[] args) {
		ShibaInu shibaInu = new ShibaInu("Kabosu", 14);
		System.out.println(shibaInu.ToString());
		shibaInu.setName("Subaru");
		shibaInu.setAge(10);
		System.out.println(shibaInu.ToString());
	}

}