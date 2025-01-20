package applicationUsingJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbcproject {

	public static void main(String[] args) {
		
	try {
		
		//1. register the driver class
		Class.forName("com.mysql.cj.jdbc.Driver"); // object create
		
		// 2. create connection
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "vaishnavi@1234");
		
		// 3. createw statement
		Statement stmt = conn.createStatement();
		
		// 4. create sql query 
		String query = "select * from student where id=102";
		
		// 5. execute query
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" | "+rs.getString("name"));
		}
		
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	}
}
	
