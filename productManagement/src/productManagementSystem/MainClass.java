package productManagementSystem;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        ProductManagementSystem system = new ProductManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("*** Product Management System ***");
            System.out.println("1. Add a Product");
            System.out.println("2. Remove a Product");
            System.out.println("3. View All Products");
            System.out.println("4. Search Product by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    system.addProduct(id, name, price);
                    break;
                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    system.removeProduct(removeId);
                    break;
                case 3:
                    System.out.println("All Products:");
                    system.viewAllProducts();
                    break;
                case 4:
                    System.out.print("Enter Product ID to search: ");
                    int searchId = scanner.nextInt();
                    system.searchProductById(searchId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
