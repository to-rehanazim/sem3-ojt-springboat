package com.pwioi.hibernate;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import org.hibernate.HibernateException;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

import com.pwioi.hibernate.entities.Profile;

/**
 * Hello world!
 */

public class App {

	public static void main(String[] args) {

    	Configuration cfg = new Configuration();

    	cfg.addAnnotatedClass(Profile.class);

    	SessionFactory factory = cfg.buildSessionFactory();

    	try (Session ss = factory.openSession();

    			FileInputStream fis = new FileInputStream("./target/classes/images/ChatGPT Image Aug 14, 2026, 02_15_22 PM.png");

    			FileReader fr = new FileReader("./target/classes/docs/anoop_resume.txt")

    			) {

    			Transaction tx = null;

    			try {

    				tx = ss.beginTransaction();

    				// database operations

    				Profile profile = new Profile();

    				profile.setName("tejas_resume.txt");

    				byte [] photo = fis.readAllBytes();

    				profile.setPhoto(photo);

    				char [] resume = IOUtils.toCharArray(fr);

    				profile.setResume(resume);

    				ss.persist(profile);

    				tx.commit();

    			} catch (Exception e) {

    				if (tx != null) {

    					tx.rollback();

    				}

    				throw e;

    			}

    	} catch (HibernateException e) {

    		e.printStackTrace();

    	} catch (FileNotFoundException e1) {

    		e1.printStackTrace();

    	} catch (IOException e1) {

    		e1.printStackTrace();

    	}

    }

}