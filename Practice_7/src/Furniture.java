public abstract class Furniture {
	private String name = null;
	private String material = null;
	Furniture(String name, String material)
	{
		this.name = name;
		this.material = material;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMaterial() {
		return this.material;
	}

	public abstract String ToString();
}
