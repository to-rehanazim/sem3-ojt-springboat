package com.pwioi.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;       
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.pwioi.jdbc.config.DBConnectivity;

public class DateSelectDemo {
    public static void main(String[] args) {
        // Query string moved outside for clean readability
        String query = "SELECT id, name, joining_date FROM employee WHERE id = ?";

        // Added PreparedStatement to the try-with-resources block
        try (
            Connection con = DBConnectivity.getDBConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in);
        ) {
            System.out.println("Database Connection established");
            
            System.out.print("Enter Employee ID: ");
            int empID = sc.nextInt();
            
            // Set the positional parameter
            pstmt.setInt(1, empID);
            
            // 3. Execute the query and process results
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString(2);
                    // Handles the SQL Date type cleanly
                    java.sql.Date joiningDate = rs.getDate("joining_date"); 
                    LocalDate date =joiningDate.toLocalDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String indianDate = date.format(formatter);
                    
                    System.out.println("\n--- Employee Details ---");
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Joining Date: " + indianDate);
                } else {
                    System.out.println("No employee found with ID: " + empID);
                }
            }
            
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

