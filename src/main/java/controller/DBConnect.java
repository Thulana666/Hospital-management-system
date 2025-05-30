package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	// Create database connection for all project with (Microsoft SQL Server)
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String host     = "localhost";
        String instance = "LAPTOP-Randiv\\SQLEXPRESS";
        String database = "Hospital_Management_System";
        String uname    = "sa";		// User name
        String pas      = "9876";	// Password

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url = "jdbc:sqlserver://"+host+":1433;"+"instance="+instance+";databaseName="+database;

        Connection con = DriverManager.getConnection(url, uname, pas);

        System.out.println("Connected to database!");

        return con;
	}

}
