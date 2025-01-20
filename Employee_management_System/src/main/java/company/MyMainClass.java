package company;

import java.util.Scanner;

public class MyMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeService service = new EmployeeService ();
		Scanner sc = new Scanner (System.in);
		while(true)
		{
			System.out.println("1. add an employee");
			System.out.println("2. view an employee");
			System.out.println("3. add an exit");
			
			System.out.println("enter your choice");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("enter the id");
				int id =sc.nextInt();
				System.out.println("enter the name");
				String name =sc.next();
				System.out.println("enter the departmant");
				String department =sc.next();
				System.out.println("enter the salary");
				int salary =sc.nextInt();
				
				Employee employee = new Employee(id,name,department,salary);
				service.addEmployee(employee);
				break;
			case 2:
				System.out.println("employee list");
				for(Employee emp : service.getAllEmployee()) {
				System.out.println(emp);	
			    }
				break;
				
			case 3:
				System.out.println("existing");
				sc.close();
				System.exit(0);
				break;
			
			default:
				System.out.println("invalid choice...");
		}
	}
	}
}

