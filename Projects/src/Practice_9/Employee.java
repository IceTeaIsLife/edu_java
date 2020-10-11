package Practice_9;

import java.util.GregorianCalendar;

public class Employee {
	private String name;
	private String surname;
	private final GregorianCalendar dateOfBirth;
	private String location;
	private String number;
	private double salary;

	public Employee(String name, String surname, GregorianCalendar dateOfBirth, String location, String number, double salary) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.location = location;
		this.number = number;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
