package com.pwioi.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {

    public static Connection getDBConnection() throws IOException, SQLException {

        Properties props = new Properties();

        props.load(new FileInputStream("./target/classes/db.properties"));

        return DriverManager.getConnection(
                props.getProperty("url"),
                props.getProperty("user"),
                props.getProperty("password")
        );
    }
}