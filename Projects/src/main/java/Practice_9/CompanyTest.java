package Practice_9;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class CompanyTest {

	public static int randBetween(int min, int max) {
		return min + (int) Math.round(Math.random() * (max - min));
	}

	public static GregorianCalendar randDateOfBirth(GregorianCalendar gregorianCalendar) {
		int year = randBetween(1970, 2000);
		gregorianCalendar.set(gregorianCalendar.YEAR, year);
		//int month = randBetween(1,12);
		//gregorianCalendar.set(gregorianCalendar.MONTH, month);
		int dayOfYear = randBetween(1, gregorianCalendar.getActualMaximum(gregorianCalendar.DAY_OF_YEAR));
		gregorianCalendar.set(gregorianCalendar.DAY_OF_YEAR, dayOfYear);
		//System.out.println(gregorianCalendar.get(gregorianCalendar.YEAR) + "-" + (gregorianCalendar.get(gregorianCalendar.MONTH) + 1) + "-" + gregorianCalendar.get(gregorianCalendar.DAY_OF_MONTH));
		return gregorianCalendar;
	}

	public static void doSome(Employee employee, int index) {
		System.out.println("=======" + index + "=======");
		System.out.println(employee);
	}

	public static void main(String[] args) {
		Company company = new Company();
		long number = 8927000000L;

		for (int i = 0; i < 20; i++) {
			company.hireAll(new Employee("Ooga",
							"Booga",
							randDateOfBirth(new GregorianCalendar()), "Detroit",
							String.valueOf(number + randBetween(0, 999999)),
							randBetween(50000, 70000)),
					new Employee("Git",
							"Damoney",
							randDateOfBirth(new GregorianCalendar()), "Detroit",
							String.valueOf(number + randBetween(0, 999999)),
							randBetween(50000, 70000))
			);
		}

		company.HandleEmployees(new SalarySelector(60000, 65000),
				(employee, index) -> System.out.println("employee " + index + ":" + employee));


		int year = 1980;
		company.HandleEmployees(new EmployeeSelector() {
									@Override
									public boolean isNeedEmployee(Employee employee) {
										return employee.getDateOfBirth().get(employee.getDateOfBirth().YEAR) > year;
									}
								}, new EmployeeHandler() {
									@Override
									public void handleEmployee(Employee employee, int index) {
										System.out.println("=======" + index + "=======");
										System.out.println(employee);
									}
								}
		);

		company.HandleEmployees(employee -> employee.getSurname() == "Booga", CompanyTest::doSome);

		Scanner in = new Scanner(System.in);
		in.next();

	}

}