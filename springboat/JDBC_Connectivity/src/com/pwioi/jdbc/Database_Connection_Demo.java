package com.pwioi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Connection_Demo {
	
	public static void main(String[] args) {
	 Connection con = null;
	 try {
		 
		 
		 // step: 1 LOad JDBC DRIVER(optional or implicit)
		 // class.forName("fully qualified jdbc driver class name")//explicitly loads class
		 //class.forName("com.mysql.cj.jdbc.Driver.class";)
		 
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false","root","root");
		System.out.println("Database Connection is established successfully!");
		// Step3 . Obtain Statement object from connection object 
					Statement stmt = con.createStatement();
					
					// Step4. Create SQL query and fire the query
		             String sql = "SELECT * FROM PRODUCT";
		             ResultSet rs = stmt.executeQuery(sql);
		             
		             
		    // step 5: Navigate the result set row by row 
		             while(rs.next()) {
		            	 //step 6 : fetching individual column values using column index number
		            	 int id = rs.getInt(1);
		            	 String name =rs.getString(2);
		            	 String brand = rs.getString(3);
		            	 float price =rs.getFloat(4);
		            	 System.out.println("product Id: "+ id +
		            			 			"\tName:"+ name +
		            			 			"\tBrand:"+brand +
		            			 			"\tprice: "+ price );
		            	 
		             }
		             
		     
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			// Step 6: close the database connection (or session)
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
		
		
	}
	
}

