package com.database.students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	           public static Connection getConnection() throws ClassNotFoundException, SQLException {
	            
	        	String URL = "jdbc:mysql://localhost:3306/Students";
	       	    String USER = "root";
	       	    String PASSWORD = "root";
	       	    
	        	   
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
	           // System.out.println(connection);
	            return connection;
	        }
	
}
  