package com.pwioi.jdbc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectivity {

    public static Connection getDBConnection() throws SQLException, IOException {
        Properties props = new Properties();

        // Using try-with-resources to automatically close the file stream
        try (FileInputStream fis = new FileInputStream("dbconfig.properties")) {
            props.load(fis);
        }

        String url = props.getProperty("dburl");
        String user = props.getProperty("dbuser");
        String password = props.getProperty("dbpassword");

        return DriverManager.getConnection(url, user, password);
    }
}