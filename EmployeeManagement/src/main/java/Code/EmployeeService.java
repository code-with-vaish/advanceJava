package Code;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmployeeService {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void addEmployee(String name,String department,double salary)
	{
		org.hibernate.Session session = sessionFactory.openSession(); 
		Transaction transaction = session.beginTransaction();
		
		//create a new employee
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDepartment(department);
		employee.setSalary(salary);
		
		session.save(employee);
		transaction.commit();
		session.close();
		
	}
	
	// Method to fetch employees
	public List<Employee> getAllEmployees() {
	    Session session = sessionFactory.openSession();
	    String hql = "FROM Employee";
	    Query<Employee> query = session.createQuery(hql, Employee.class);
	    List<Employee> employees = query.getResultList();
	    session.close();
	    return employees;
	}

	public void deleteEmployee(int employeeId) {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    String hql = "Delete from Employee e where e.id = :employeeId";
	    Query query = session.createQuery(hql);
	    query.setParameter("employeeId", employeeId);
	    query.executeUpdate();
	    transaction.commit();
	    session.close();
	    System.out.println("Employee has been deleted..");
	}

	// Main Method
	public static void main(String[] args) {
	    System.out.println("hiii");
	    
	    EmployeeService service = new EmployeeService();
	    
	    // Add employees
	    service.addEmployee("Alice", "IT", 98000);
	     service.addEmployee("Bob", "Marketing", 70000);
	    service.addEmployee("Jack", "Sales", 50000);
	     service.addEmployee("Charlie", "IT", 90000);
	     System.out.println("employee added successfully....");
	    
	    // Fetch all employees
	    System.out.println("Displaying Employees: ");
	    for (Employee emp : service.getAllEmployees()) {
	        System.out.println(emp);
	    }
	    
	    // Delete an employee
	    service.deleteEmployee(5);
	    service.deleteEmployee(6);
	    service.deleteEmployee(7);
	    service.deleteEmployee(8);
	    System.out.println("Exiting...");
	}

	
}
