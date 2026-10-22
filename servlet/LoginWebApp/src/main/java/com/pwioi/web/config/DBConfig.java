package com.pwioi.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {

	public static Connection getDBConnection() throws SQLException, IOException {
		Properties props = new Properties();
		InputStream in = DBConfig.class.getClassLoader().getResourceAsStream("db.properties");
		props.load(in);
		Connection con = DriverManager.getConnection(props.getProperty("url"),
				                                         props.getProperty("username"),
				                                             props.getProperty("password"));
		
		System.out.println("Database connection is established");
		return con;
	}
}