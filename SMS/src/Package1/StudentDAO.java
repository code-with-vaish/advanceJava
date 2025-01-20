package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) throws SQLException {
        String query = "insert into students(id, name) values (?, ?)";
        Connection conn = DriverManager.getConnection(DatabaseConfig.url, DatabaseConfig.user, DatabaseConfig.password);
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, student.getId());
        pstmt.setString(2, student.getName());
        pstmt.executeUpdate();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<Student>();
        String query = "select * from students";
        Connection conn = DriverManager.getConnection(DatabaseConfig.url, DatabaseConfig.user, DatabaseConfig.password);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            students.add(new Student(id, name));
        }
        return students;
        
    }
}
