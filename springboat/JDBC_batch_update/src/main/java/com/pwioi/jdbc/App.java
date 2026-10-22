package com.pwioi.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwioi.jdbc.config.DBConfig;

public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	try(Connection con = DBConfig.getDBConnection();
    			Statement stmt = con.createStatement();
    			){
    		  System.out.println( "Database connection established" );
    		  //adding sql quires to a batch
    		  stmt.addBatch("INSERT INTO PRODUCTS VALUES(5001,'Wardrobe,'Nilkamal',6499.00)");
    		  stmt.addBatch("INSERT INTO PRODUCTS VALUES(5002,'Dining Table,'Godrej',15099.00)");
    		  stmt.addBatch("INSERT INTO PRODUCTS VALUES(5003,'LED TV,'Sony',48299.00)");
    		  stmt.addBatch("INSERT INTO PRODUCTS VALUES(5001,'Wardrobe,'Nilkamal',6499.00)");
    		  stmt.addBatch("UPDATE SET PRICE = PRICE + 500.00 WHERE ID =1 ");
    		  stmt.addBatch("UPDATE SET PRICE = PRICE -250.00 WHERE ID =2 ");
    		  
    		  //EXCUTE A ABATCH OF SQL 
    		  int [] counts = stmt.executeBatch();
    		  for(int count:counts) System.out.println("Row Affected "+count);
    	}catch (IOException | SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
}
