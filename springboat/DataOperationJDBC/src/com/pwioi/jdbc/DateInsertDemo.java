package com.pwioi.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.pwioi.jdbc.config.DBConnectivity;

public class DateInsertDemo {

    public static void main(String[] args) {
        try (Connection con = DBConnectivity.getDBConnection();
             PreparedStatement pstmt = con.prepareStatement("insert into employee(id,name,joining_date) values(?,?,?)");
             Scanner sc = new Scanner(System.in)) {
            
            System.out.println("Database Connection Established Successfully!");
            
            System.out.println("Enter Employee Id : ");
            int empId = sc.nextInt();
            
            System.out.println("Enter employee name :");
            sc.nextLine(); // consumes newline from nextInt()
            String empName = sc.nextLine();
            
            System.out.println("Enter joining date(dd-MM-yyyy) : ");
            String joiningDate = sc.next();
            
            System.out.println("EmpId:" + empId + "\tname:" + empName + "\tJoining Date :" + joiningDate);
            
            // 1. Define custom format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            
            // 2. Pass the formatter to parse custom date string
            LocalDate date = LocalDate.parse(joiningDate, formatter); 
            System.out.println("Parsed Date :" + date);
            Date dbDate= Date.valueOf(date);
            
            // 3. Insert into Database
            pstmt.setInt(1, empId);
            pstmt.setString(2, empName);
            pstmt.setDate(3, dbDate); // Converts LocalDate to java.sql.Date
            
            
            
            
            int updateCount = pstmt.executeUpdate();
            if (updateCount>0) 
            System.out.println(updateCount + " record(s) inserted successfully!");
            else 
            	 System.out.println("Sorry! record couble be inserted ");
            
          } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}