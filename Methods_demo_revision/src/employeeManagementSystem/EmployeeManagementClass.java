package employeeManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementClass {
	// adding removing viewing -- Arraylist

	private List<Employee> employees;

	public EmployeeManagementClass() {
		employees = new ArrayList<Employee>();
	}
	
	// add an employee

	public void addEmployee(int id, String name) {
		employees.add(new Employee(id, name));
		System.out.println(name + " Employee has been added.");
	}

	// remove an element
	public void removeEmployee(int removeId) {

		Employee empToRemove = null;
		for (Employee e : employees) {
			if (e.getId() == removeId) {
				empToRemove = e;
				break;
			}
		}
		if (empToRemove != null) {
			employees.remove(removeId);
			System.out.println("Employee has been removed successfully");
		} else {
			System.out.println("Employee with id : " + removeId + " is not found in the list..");
		}

	}

// view all employees
	
	public void viewAllEmployees() {
		if (employees.isEmpty()) {
			System.out.println("No employees are availiable to display.");
		} else {
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}

	}

// search an employee
	public void searchEmployeeById(int searchId) {

		for (Employee employee : employees) {
			if (employee.getId() == searchId) {
				System.out.println(employee);
				return;
			}
		}
		System.out.println("Employee with id " + searchId + " does not exist");
	}

}
