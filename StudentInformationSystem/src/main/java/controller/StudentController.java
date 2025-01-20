package controller;

import java.sql.SQLException;

import entity.Student;
import service.StudentService;

public class StudentController {

	StudentService studentService= new StudentService();
	public void addNewStudent(String name,int age,String email) throws SQLException
	{
		studentService.createStudent(name, age, email);
		System.out.println("student added successfully to the database");
	}
	
	public void viewStudent(int id) throws SQLException
	{
		Student student= studentService.getStudentById(id);
		if(student!=null)
		{
			System.out.println(student);
		}
		else
		{
			System.out.println("student not found");
		}
	}
}
