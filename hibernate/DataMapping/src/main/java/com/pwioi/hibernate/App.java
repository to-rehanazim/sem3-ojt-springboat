package com.pwioi.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.pwioi.hibernate.entities.Student;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	
    	Configuration cfg = new Configuration();
    	cfg.addAnnotatedClass(Student.class);
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	
    	try (Session ss = factory.openSession();
    			
    	   	Scanner scan = new Scanner(System.in);	
    		 	
    			) {
    		
    		Transaction tx = ss.beginTransaction();
    		
    		//database operations here
    		Student s = new Student();
    		// accept user inputs
    		System.out.println("Enter name of Students");
    		String name = scan.nextLine();
    		
    		System.out.println("Enter admission date of student");
    		String date = scan.next();
    		
    		LocalDate admissionDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    		
    		s.setName(name);
    		s.setAdmissionDate(admissionDate);
    		
    		// save entity into database
    		ss.persist(s);
    		
    		tx.commit();
    		
    		tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}