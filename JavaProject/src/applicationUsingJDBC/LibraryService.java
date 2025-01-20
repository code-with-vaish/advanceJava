  package applicationUsingJDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Service
public class LibraryService {

	private List<Book> books;
	private BookDAO bookDAO;

	public LibraryService() throws SQLException {
		books = new ArrayList<Book>();
		bookDAO = new BookDAO();
	}

	public void addBook(Book book) throws SQLException {
		books.add(book);
		bookDAO.addBook(book);
	}

	public List<Book> getAllBooks() throws SQLException {
		books = bookDAO.getBooks();
		return books;
	}

	public void close() throws SQLException {
		bookDAO.close();
	}

}
