package Practice_7;

public class PlateTest {
	public static void main(String[] args) {
		Plate plate = new Plate("ceramics", 50, 25);
		System.out.println(plate.ToString());
		plate.setMaterial("glass");
		plate.setPrice(45);
		plate.setDiameter(30);
		System.out.println(plate.ToString());
	}
}