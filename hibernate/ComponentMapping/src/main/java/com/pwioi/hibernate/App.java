package com.pwioi.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pwioi.hibernate.entities.Name;
import com.pwioi.hibernate.entities.person;


public class App 
{
    public static void main( String[] args )
    {
      Configuration c = new Configuration();
      c.addAnnotatedClass(person.class);
      SessionFactory factory = c.buildSessionFactory();
      try (Session ss = factory.openSession()) {
    	  Transaction tx = ss.beginTransaction();
    	  //database operations
    	  Name personName = new Name("Rahul","Tanmay","Malhotra");
    	  person person = new person();
    	  person.setPersonName(personName);
    	  person.setAge(22.5f);
    	  ss.persist(person);
    	  tx.commit();
	} 
      
      catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
    }
}