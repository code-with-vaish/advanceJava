package service;

import java.sql.SQLException;

import dao.StudentDAO;
import entity.Student;

public class StudentService {
	
	StudentDAO studentDao = new StudentDAO();
	public void createStudent(String name,int age,String email) throws SQLException
	{
		Student student =new Student();
		student.setName(name);
		student.setAge(age);
		student.setEmail(email);
		studentDao.addStudent(student);
	}
	
	public Student getStudentById(int id) throws SQLException
	{
		return studentDao.getStudent(id);
	}

}
