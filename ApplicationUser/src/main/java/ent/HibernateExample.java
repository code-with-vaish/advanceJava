package ent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        //step 1
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Connection success...");
        User newUser = new User();
        newUser.setId(0);
        newUser.setName("vaish");
        newUser.setEmail("vaish@123");

        session.save(newUser);
        session.getTransaction().commit();
        session.close();
        System.out.println("User has been added successfully");
        
        
        //step 3
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        User retrievedUser = session.get(User.class, 2);
        if(retrievedUser != null)
        {
        	System.out.println("Retrieved user details:"+retrievedUser.getId());
        }

        sessionFactory.close();
      
        //4: Update the user by ID
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        User retrievedUser1 = session.get(User.class, 1);
       
        if(retrievedUser1 !=null)
        {
        	System.out.println("Retrieved user details:"+retrievedUser1.getId()+" "+retrievedUser1.getName()+" "+retrievedUser1.getEmail());
        	
        }
        else
        {
        	System.out.println("user not found");
        }
        session.getTransaction().commit();
        session.close();
        
        //delete data user on basis of id
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        User deleteUser = session.get(User.class, 1);
        if(retrievedUser != null )
        {
        	session.delete(deleteUser);
        	System.out.println("user deleted successfully");
        }
        else {
        	System.out.println("user not found");
        }
        session.getTransaction().commit();
        session.close();
        
        sessionFactory.close();
        System.out.println("hii....");
    }
}
