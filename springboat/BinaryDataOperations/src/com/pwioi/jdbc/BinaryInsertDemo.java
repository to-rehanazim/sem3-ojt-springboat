package com.pwioi.jdbc;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pwioi.jdbc.config.DBConfig;

public class BinaryInsertDemo {

	public static void main(String[] args) {
		
		
		try (// TODO Auto-generated method stub)
			Connection con = DBConfig.getDBConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into profiles(name,photo,resume) values(?,?,?)");
			FileInputStream fis = new FileInputStream("./resources/profile_picture.jpg");
			FileReader fr= new FileReader("./resources/resume.txt");
				) {
			System.out.println("Database Connection established");
			
			pstmt.setString(1, "Tejas Malhotra");
			pstmt.setBinaryStream(2, fis);
			pstmt.setCharacterStream(3, fr);
			
			int update=pstmt.executeUpdate();
			if(update>0)
				System.out.println("profile inserted successfull");
			else 
				System.out.println("Sorry! data could not be inserted");
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}