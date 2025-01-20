package employeeManagementSystem;

import java.util.Scanner;

public class MyMainClass {

	public static void main(String[] args) {

		EmployeeManagementClass system = new EmployeeManagementClass();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("***Employee Management System****");
			System.out.println("1. Add an employee");
			System.out.println("2. Remove an employee");
			System.out.println("3. View all employees");
			System.out.println("4. Search an employee by ID");
			System.out.println("5. Exit");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter employee Details : ");
				System.out.println("Enter Id : ");
				int id = sc.nextInt();
				System.out.println("Enter Name : ");
				String name = sc.next();
				system.addEmployee(id, name);
				break;

			case 2:
				System.out.println("Enter employee Id to remove an employee : ");
				int removeId = sc.nextInt();
				system.removeEmployee(removeId);
				break;

			case 3:
				System.out.println("Displaying All employees : ");
				system.viewAllEmployees();
				break;
			case 4:
				System.out.println("Enter employee Id to search an employee : ");
				int searchId = sc.nextInt();
				system.searchEmployeeById(searchId);
				break;
			case 5:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid Choice.");
			}
			
			
		} while (choice != 5);
		sc.close();

	}
}
