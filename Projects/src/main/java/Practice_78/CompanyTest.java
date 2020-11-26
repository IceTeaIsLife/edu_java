package Practice_78;

import java.util.Scanner;

public class CompanyTest {
	public static void main(String[] args) {
		Company company = new Company();
		for (int i = 0; i < 60; i++) {
			company.hireAll(new Employee("Oper", "Ator", (int) (40000 + Math.random() * 10000), new Operator()),
					new Employee("Oper", "Ator", (int) (40000 + Math.random() * 10000), new Operator()),
					new Employee("Oper", "Ator", (int) (40000 + Math.random() * 10000), new Operator()));
		}
		for (int i = 0; i < 40; i++) {
			company.hireAll(new Employee("Man", "Ager", (int) (80000 + Math.random() * 10000), new Manager()),
					new Employee("Man", "Ager", (int) (80000 + Math.random() * 10000), new Manager()));
		}
		for (int i = 0; i < 10; i++) {
			company.hire(new Employee("Top", "Manager", (int) (90000 + Math.random() * 10000), new TopManager(company)));
		}

		company.workOneMonth();    //компания работает 1 месяц

		System.out.println("Топ самых высоких зарплат");
		for (Employee employee : company.getTopSalaryStaff(10))  //выводим топ самых высоких зарплат
		{
			System.out.println((int) employee.getTotal() + " руб.");
		}

		System.out.println("\nТоп самых низких зарплат");
		for (Employee employee : company.getLowestSalaryStaff(30))    //выводим топ самых низких зарплат
		{
			System.out.println((int) employee.getTotal() + " руб.");
		}

		company.firePercents(50);	//уволняем 50% сотрудников

		System.out.println("Топ самых высоких зарплат");
		for (Employee employee : company.getTopSalaryStaff(10))  //выводим топ самых высоких зарплат
		{
			System.out.println((int) employee.getTotal() + " руб.");
		}

		System.out.println("\nТоп самых низких зарплат");
		for (Employee employee : company.getLowestSalaryStaff(30))    //выводим топ самых низких зарплат
		{
			System.out.println((int) employee.getTotal() + " руб.");
		}

		if (true) {                                                    //for debug
			Scanner in = new Scanner(System.in);
			in.next();
		}
	}
}