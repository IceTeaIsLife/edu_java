public class Dog {
    private String name = null;
    private int age = 0;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int toHumanAge()
    {
        return this.age*7;
    }

    public String ToString()
    {
        return "This dog named " + this.name + " and it's age is " + this.age;
    }

}
