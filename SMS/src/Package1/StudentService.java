package Package1;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDAO studentDao = new StudentDAO();

    public void registerStudent(Student student) throws SQLException {
        if (student.getName() != null && !student.getName().isEmpty() && student.getId() > 0) {
            studentDao.addStudent(student);
        } else {
            System.out.println("Invalid student details...");
        }
    }

    public List<Student> getStudent() throws SQLException {
        return studentDao.getAllStudents();
    }
}
