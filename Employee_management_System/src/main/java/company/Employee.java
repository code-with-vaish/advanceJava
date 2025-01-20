package company;

public class Employee {

	private int id;
	private String name;
	private String department;
	private int salary;
	public Employee(int id, String name, String department, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public int getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
	
	
	
}
