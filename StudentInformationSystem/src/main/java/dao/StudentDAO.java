package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Student;

public class StudentDAO {
private static final String URL ="jdbc:mysql://localhost:3306/student_db";
private static final String USER = "root";
private static final String PASSWORD ="vaishnavi@1234";


public void addStudent(Student student) throws SQLException
{
	String query = "insert into student(name,age,email)values(?,?,?)";
	Connection conn =DriverManager.getConnection(URL, USER, PASSWORD);
	PreparedStatement pstmt = conn.prepareStatement(query);
	pstmt.setString(1, student.getName());
	pstmt.setInt(2, student.getAge());
	pstmt.setString(3, student.getEmail());
	pstmt.executeUpdate();
}

public Student getStudent(int id) throws SQLException
{
	Student student = null;
	String query="select * from student where student_Id=?";
	Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setInt(1, id);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next())
	{
		student= new Student();
		student.setStudent_id(rs.getInt("student_id"));
		student.setAge(rs.getInt("age"));
		student.setName(rs.getString("name"));
		student.setEmail(rs.getString("email"));
		
	}
	return student;
}
}
