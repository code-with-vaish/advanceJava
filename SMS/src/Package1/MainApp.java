package Package1;

import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		StudentController controller = new StudentController();
		
		controller.createStudent(1, "rajesh");
		controller.createStudent(2, "mukesh");
		controller.createStudent(3, "pritesh");
		
		controller.showAllStudents();

	}

}
