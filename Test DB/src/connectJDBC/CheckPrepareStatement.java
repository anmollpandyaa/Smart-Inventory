package connectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckPrepareStatement {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/university";
		String username = "root";
		String password = "!1sqlp@ssword";
		String update_query = "update students set name = ? where id = ?";
		String select_query = "select * from students;";
		String insert_query = "insert into students values(?, ?, ?);";
		String delete_query = "delete from students where id = ?;";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection established.");
	    	System.out.println("-----------------------");
	    	
			PreparedStatement select_statement = connection.prepareStatement(select_query);
			ResultSet select_result = select_statement.executeQuery();
			System.out.println("Database:");
			System.out.println("");
			while(select_result.next()) {
				int id = select_result.getInt("ID");
		    	String name = select_result.getString("Name");
		    	String course = select_result.getString("Course");
		    	System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
			}
			System.out.println("");
			
			PreparedStatement insert_statement = connection.prepareStatement(insert_query);
	    	insert_statement.setInt(1, 6);
	    	insert_statement.setString(2, "Shanaya");
	    	insert_statement.setString(3, "CMC");
	    	int insert_result = insert_statement.executeUpdate();
			System.out.println("new data inserted, " + insert_result + " rows affected.");
			System.out.println("");
			select_result = select_statement.executeQuery();
			while(select_result.next()) {
				int id = select_result.getInt("ID");
		    	String name = select_result.getString("Name");
		    	String course = select_result.getString("Course");
		    	System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
			}
			System.out.println("");	 
			
			PreparedStatement delete_statement = connection.prepareStatement(delete_query);
			delete_statement.setInt(1, 6);
			int delete_result = delete_statement.executeUpdate();
			System.out.println("data deleted, " + delete_result + " rows affected.");
			System.out.println("");
			select_result = select_statement.executeQuery();
			while(select_result.next()) {
				int id = select_result.getInt("ID");
		    	String name = select_result.getString("Name");
		    	String course = select_result.getString("Course");
		    	System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
			}
			System.out.println("");

			
			PreparedStatement update_statement = connection.prepareStatement(update_query);
			update_statement.setString(1, "Rajyawardhan");
			update_statement.setInt(2, 5);
			int update_result = update_statement.executeUpdate();
		    System.out.println("database updated, " + update_result + " rows affected.");
		    System.out.println("");
			
		    select_result = select_statement.executeQuery();
			while(select_result.next()) {
				int id = select_result.getInt("ID");
		    	String name = select_result.getString("Name");
		    	String course = select_result.getString("Course");
		    	System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
			}
			System.out.println("");
			
	    	   	
	    	connection.close();
			System.out.println("connection closed.");
	    	System.out.println("-----------------------");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
