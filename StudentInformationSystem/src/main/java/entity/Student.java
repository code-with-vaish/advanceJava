package entity;

public class Student {

	private int Student_id;
	private String name;
	private int age;
	private String email;
	
	
	public int getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(int i) {
		Student_id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [Student_id=" + Student_id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
	
}
