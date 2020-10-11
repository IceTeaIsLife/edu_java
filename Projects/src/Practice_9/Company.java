package Practice_9;

import java.util.ArrayList;

public class Company {
	private final ArrayList<Employee> employees;

	public Company() {
		employees = new ArrayList<>();
	}

	public void hire(Employee employee) {
		employees.add(employee);
	}

	public void hireAll(Employee employee, Employee... employees) {
		hire(employee);
		for (Employee empl : employees) {
			hire(empl);
		}
	}

	public void fire() {
		employees.remove(employees.size() - 1);
	}

	public void HandleEmployees(EmployeeSelector selector, EmployeeHandler handler) {
		int count = 0;
		for (Employee employee : employees) {
			if (selector.isNeedEmployee(employee)) {
				handler.handleEmployee(employee, count);
				count++;
			}
		}
		System.out.println(count);
	}

	public void firePercents(int percents) {
		int den = 100 / percents;

		int fireNum = employees.size() / den;
		for (int i = 0; i < fireNum; i++) {
			this.fire();
		}

		System.out.println("Было уволено " + percents + "% сотрудников");
	}

	@Override
	public String toString() {
		return "Company{" +
				"employees=" + employees +
				'}';
	}
}
