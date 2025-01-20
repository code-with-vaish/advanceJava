package company;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

	List<Employee> employees = new ArrayList <Employee>();
	
	public void addEmployee(Employee employee)
	{
		employees.add(employee);
		System.out.println("the employee added successfully");
	}
	
	public List<Employee> getAllEmployee()
	{
		return employees;
	}

}
