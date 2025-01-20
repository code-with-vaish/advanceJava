package Package1;

import java.sql.SQLException;

public class StudentController {
    StudentService studentService = new StudentService();

    public void createStudent(int id, String name) throws SQLException {
        Student student = new Student(id, name);
        studentService.registerStudent(student);
        System.out.println("Student has been added.");
    }

    public void showAllStudents() throws SQLException {
        System.out.println("All details are as: ");
        for (Student stu : studentService.getStudent()) {
            System.out.println(stu);
        }
    }
}
