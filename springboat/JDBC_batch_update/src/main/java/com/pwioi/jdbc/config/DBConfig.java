package com.pwioi.jdbc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {
	public static Connection getDBConnection() throws IOException, SQLException {
		FileInputStream fis = new FileInputStream("./traget/classes/db.properties");
		Properties props = new Properties();
		props.load(fis);

		return DriverManager.getConnection(props.getProperty("Url"),props.getProperty("User"),props.getProperty("Password"));
	}
}