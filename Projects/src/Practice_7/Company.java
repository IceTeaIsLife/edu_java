package Practice_7;

//import java.util.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
	private long income;
	//private List<Employee> Staff;
	private List<Employee> Operators = new ArrayList<Employee>();
	private List<Employee> Managers = new ArrayList<Employee>();
	private List<Employee> TopManagers = new ArrayList<Employee>();


	public void hire(Employee employee) {
		switch (employee.getEmployeePosition().getJobTitle()) {
			case "Operator": {
				Operators.add(employee);
				break;
			}
			case "Manager": {
				Managers.add(employee);
				break;
			}
			case "TopManager": {
				TopManagers.add(employee);
				break;
			}
		}
	}

	public void hireAll(Employee employee, Employee... employees) {
		hire(employee);
		for (Employee value : employees) {
			hire(value);
		}
	}

	public void fire(String position) {
		switch (position) {
			case "Operator": {
				Operators.remove(Operators.size() - 1);
				break;
			}
			case "Manager": {
				Managers.remove(Managers.size() - 1);
				break;
			}
			case "TopManager": {
				TopManagers.remove(TopManagers.size() - 1);
				break;
			}
		}
	}

	public void firePercents(int percents)                //метод "увольняет" сотрудников с самыми низкими зарпалатами, аргумент - процент от общего штата
	{
		int den = 100 / percents;

		Operators.sort(Comparator.comparing(Employee::getTotal).reversed());
		int fireNum = Operators.size() / den;
		for (int i = 0; i < fireNum; i++) {
			this.fire("Operator");
		}

		Managers.sort(Comparator.comparing(Employee::getTotal).reversed());
		fireNum = Managers.size() / den;
		for (int i = 0; i < fireNum; i++) {
			this.fire("Manager");
		}

		TopManagers.sort(Comparator.comparing(Employee::getTotal).reversed());
		fireNum = TopManagers.size() / den;
		for (int i = 0; i < fireNum; i++) {
			this.fire("TopManager");
		}

		System.out.println("Было уволено "+ percents + "% сотрудников");
	}

	public void workOneMonth() {			//метод начисления зарплаты сотрудникам за "месяц" работы
		for (Employee manager : Managers) {
			manager.setTotal(manager.getEmployeePosition().calcSalary(manager.getSalary()));
			income += (manager.getTotal() - manager.getSalary()) * 20;			//достаем из Manager количество заработанных денег для компании
		}
		for (Employee operator : Operators) {
			operator.setTotal(operator.getEmployeePosition().calcSalary(operator.getSalary()));
		}
		for (Employee topManger : TopManagers) {
			topManger.setTotal(topManger.getEmployeePosition().calcSalary(topManger.getSalary()));
		}
	}

	public double getIncome() {
		return income;
	}

	public List<Employee> getTopSalaryStaff(int count) {
		if (count > 0) {
			List<Employee> Staff = new ArrayList<Employee>();	//создаем временный список всех сотрудников
			Staff.addAll(Operators);
			Staff.addAll(Managers);
			Staff.addAll(TopManagers);
			if (count <= Staff.size()) {
				Staff.sort(Comparator.comparing(Employee::getTotal).reversed());	//сортировка по полю total по убыванию
				return Staff.subList(0, count);
			}
			return null;
		}
		return null;
	}

	public List<Employee> getLowestSalaryStaff(int count) {
		if (count > 0) {
			List<Employee> Staff = new ArrayList<Employee>();
			Staff.addAll(Operators);
			Staff.addAll(Managers);
			Staff.addAll(TopManagers);
			if (count <= Staff.size()) {
				Staff.sort(Comparator.comparing(Employee::getTotal));	//сортировка по полю total по возрастанию
				return Staff.subList(0, count);
			}
			return null;
		}
		return null;
	}
}
