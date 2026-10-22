package com.pwioi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				// try-with-resources(ARM-Automatic Resource Management)
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
				PreparedStatement pstmt = con.prepareStatement("insert into product (id, name, brand, price) values(?, ?, ?, ?)")
		) 
		{
			System.out.println("Database Connection Established");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the product id:");
			int id = sc.nextInt();
			System.out.println("Enter product name:");
			sc.nextLine();
			String name =sc.nextLine();
			System.out.println("Enter the brand:");
			String brand =sc.nextLine();
			System.out.println("Enter price");
			float price = sc.nextFloat();
			
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, brand);
			pstmt.setFloat(4, price);
			
			
			int updateCount=pstmt.executeUpdate();
			if(updateCount>0)
				System.out.println("New product added successfully!");
			else
				System.out.println("Product could not be added.plese try again..");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}