package code;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class EmployeeManager {



	public static void main(String[] args) {
		// TODO Auto-generated method stub f
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		addEmployees(session);
		
		System.out.println("Displaying required data");
		System.out.println("employees with greater than 50000");
		getEmployeesBySalary(session,50000);
		System.out.println("success");
		
		System.out.println("displaying required data");
		System.out.println("employees the specific designation");
		getEmployeesByDesignation(session,"developer");
		System.out.println("success");
		session.close();
		factory.close();
	}

	private static void getEmployeesByDesignation(Session session, String designation) {
		Criteria criteria = session.createCriteria(Employees.class);
		criteria.add(Restrictions.eq("salary", designation));
		List<Employees> employees = criteria.list();
		for(Employees emp : employees)
		{
			System.out.println(emp);
		}
		
	}

	private static void getEmployeesBySalary(Session session, int salary) {
		// TODO Auto-generated method stub
		Criteria criteria = session.createCriteria(Employees.class);
		criteria.add(Restrictions.gt("salary", salary));
		List<Employees> employees = criteria.list();
		for(Employees emp : employees)
		{
			System.out.println(emp);
		}
	}

	private static void addEmployees(Session session) {
		
		Transaction tx = session.beginTransaction();
		
		Employees e1 = new Employees();
		e1.setName("vaishanvi");
		e1.setDesignation("manager");
		e1.setSalary(60000);
		
		Employees e2 = new Employees();
		e2.setName("shreya");
		e2.setDesignation("developer");
		e2.setSalary(70000);
		
		
		session.save(e1);
		session.save(e2);
		tx.commit();
	}
	
	

}
