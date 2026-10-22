package com.pwioi.hybernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.mapping.List;
import org.hibernate.cfg.Configuration;

import com.pwioi.hibernate.entities.Product;

import jakarta.persistence.Query;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	Configuration cfg = new Configuration();
    	cfg.addAnnotatedClass(com.pwioi.hibernate.entities.Product.class);
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	try (Session ss = factory.openSession()) {
    		
    		//Query query = ss.createQuery("from Product", Product.class);
    		//Query query = ss.createQuery("from Product p where p.price between 99.00 and 50000.00", Product.class);
    		//Query query = ss.createQuery("from Product p order by p.price", Product.class);
    		//Query query = ss.createQuery("from Product p order by p.price DESC", Product.class);
    		
    		//Query query = ss.createQuery("from Product p order by name", Product.class);
    		//Query query = ss.createQuery("from Product p order by name,brand", Product.class);
    		
    		//Query query = ss.createQuery("from Product where name like 'G%'", Product.class);
    		
    		//Query query = ss.createNativeQuery("SELECT * FROM product", Product.class);
    		
    		Query query = ss.createNativeQuery("SELECT * FROM product where price>99 AND price<599", Product.class);
    		List<Product> productList = query.getResultList();
    		productList.forEach(p->System.out.println(p));
    		
//    		for(Product product:productList)
//    			System.out.println(product);
    		
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
        
        
    }
}