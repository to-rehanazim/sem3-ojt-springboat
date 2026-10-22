package com.pwioi.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pwioi.hibernate.entities.Country;
import com.pwioi.hibernate.entities.State;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       Configuration cfg = new Configuration();
       cfg.addAnnotatedClass(Country.class);
       cfg.addAnnotatedClass(State.class);
       
       SessionFactory factory= cfg.buildSessionFactory();
       try (Session ss = factory.openSession()) {
    	   
    	   Transaction tx = null;
    	   try {
    		   
    		   tx=ss.beginTransaction();
    		   
    		   //database  operations
    		   Country country = new Country();
    		   country.setName("India");
    		   country.setPopulation(147_00_00_000);
    		   
    		   State mh =   new State();
    		   mh.setName("Maharashtra");
    		   
    		   State up =   new State();
    		   mh.setName("Uttar Pradesh");
    		   
    		   State mp =   new State();
    		   mh.setName("Madhya Pradesh");
    		   
    		   State kr =   new State();
    		   mh.setName("Karnataka");
    		   
    		   List<State> states = Arrays.asList(mh,up,mp,kr);
    		   country.setStates(states);
    		   
    		  mh.setCountry(country);
    		  up.setCountry(country);
    		  mp.setCountry(country);
    		  kr.setCountry(country);
    		  
    		  
    		  //saving all objects in database as rows
    		  ss.persist(country);
    		  ss.persist(mh);
    		  ss.persist(up);
    		  ss.persist(mp);
    		  ss.persist(kr);
    		  
    		   
    		   tx.commit();
    	   }catch (Exception e) {
			// TODO: handle exception
    		   if(tx!=null)
    			   tx.rollback();
    		   
    		   throw e;
		}
    		   
    		   
    	   
    	   
    	   
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
    }
}
