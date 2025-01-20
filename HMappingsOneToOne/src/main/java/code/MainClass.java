package code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class).buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();
		
		//create a passport
		
		Passport passport = new Passport();
		passport.setPassportNumber("P11123");
		passport.setCountry("india");
		
		//CREATE PERSON
		Person person = new Person();
		person.setName("rajesh");
		person.setAge(21);
		person.setPassport(passport);
		
		session.save(person);
		session.getTransaction().commit();
		
		System.out.println("data saved successfully");
		session.close();
		factory.close();
	}

}
