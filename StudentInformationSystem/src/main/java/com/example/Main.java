package com.example;

import java.sql.SQLException;

import controller.StudentController;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		StudentController controller = new StudentController();
		controller.addNewStudent("vijay", 20, "vijay@.com");
		controller.addNewStudent("vikas", 21, "vikas@.com");
		
		controller.viewStudent(3);
		
	}

}
