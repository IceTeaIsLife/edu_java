package Practice_2;

import java.util.ArrayList;
import java.util.List;

public class DogKennel {
	private int maxCapacity = 100;
	ArrayList<Dog> dogs = new ArrayList<Dog>();

	public void addDog(Dog dog)
	{
		dogs.add(dog);
	}
}
