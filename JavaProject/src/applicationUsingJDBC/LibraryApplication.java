
package applicationUsingJDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//Service
public class LibraryApplication {

	public static void main(String[] args) throws SQLException {

		System.out.println("hiii");
		LibraryService libraryService = new LibraryService();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Library Management System : ");

		boolean exit = false;

		while (!exit) {
			System.out.println("1. Add Book ..");
			System.out.println("2. Display All Books");
			System.out.println("3. Exit ");
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.println("Enter Title : ");
				String title = sc.nextLine();
				System.out.println("Enter Author Name : ");
				String author = sc.nextLine();
				System.out.println("Enter Published_Year : ");
				int year = sc.nextInt();
				Book newBook = new Book(0, title, author, year);
				libraryService.addBook(newBook);
				System.out.println("New Book Has Been Added...Thanks");
				break;

			case 2:
				List<Book> books = libraryService.getAllBooks();
				if (books.isEmpty()) {
					System.out.println("No book availiable");
				} else {
					books.forEach(System.out::println);
				}
				break;

			case 3:
				exit = true;
				libraryService.close();
				System.out.println("Exiting from the application... Thanks...");
			default:
				System.out.println("Invalid Choice...");

			}
		}

	}

}
