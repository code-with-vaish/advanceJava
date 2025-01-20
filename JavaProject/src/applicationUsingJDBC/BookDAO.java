package applicationUsingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO
public class BookDAO {

	private Connection connection;

	public BookDAO() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "vaishnavi@1234t");
	}
	
	 

	public void addBook(Book book) throws SQLException {
		String query = "insert into books(title,author,published_year) values (?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, book.getTitle());// title
		pstmt.setString(2, book.getAuthor());
		pstmt.setInt(3, book.getPublishedYear());
		pstmt.executeUpdate();
	}

	public List<Book> getBooks() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from books");

		while (rs.next()) {
			Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
					rs.getInt("published_year"));
			books.add(book);
		}
		return books;
	}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
		connection.close();
	}

}
