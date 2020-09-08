public class MugTest {
	public static void main(String[] args) {
		Mug mug = new Mug("aluminium", 30, 200);
		System.out.println(mug.ToString());
		mug.setMaterial("ceramics");
		mug.setPrice(40);
		mug.setVolume(400);
		System.out.println(mug.ToString());
	}
}