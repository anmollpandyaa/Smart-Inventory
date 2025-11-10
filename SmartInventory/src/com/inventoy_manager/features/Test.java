package com.inventoy_manager.features;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
    	
        String url = "jdbc:mysql://localhost:3306/first";
        String username = "root";
        String password = "!1sqlp@ssword";
        String select_query = "select * from students;";
        try {

            // Establish connection
            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database!");
			Statement statement = conn.createStatement();

			
		    ResultSet result = statement.executeQuery(select_query);
		    System.out.println("Database: ");
		    while(result.next()) {
		    	int id = result.getInt("ID");
		    	String name = result.getString("NAME");
		    	System.out.println("ID: " + id + " | Name: " + name);
		    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
