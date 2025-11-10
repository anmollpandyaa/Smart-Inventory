package com.inventoy_manager.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Products {

	private Connection connection;
	private Scanner scanner;


	public Products(Scanner scanner, Connection connection) {
		this.connection = connection;
		this.scanner = scanner;
	}
	
	public void addProduct() {
		System.out.println("Enter product id: ");
		int product_id = scanner.nextInt();
		System.out.println("Enter product name: ");
		String product_name = scanner.next();
		scanner.nextLine();
		System.out.println("Enter product quantity: ");
		int product_quantity = scanner.nextInt();
		

		try {
			String add_query = "insert into inventory(product_id, product_name, product_quantity) values(?, ?, ?);";

			PreparedStatement add_product = connection.prepareStatement(add_query);
			add_product.setInt(1, product_id);
			add_product.setString(2, product_name);
			add_product.setInt(3, product_quantity);

			int affected = add_product.executeUpdate();

			if (affected > 0) {
				System.out.println("Product added.");
			} else {
				System.out.println("Failed to add product!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateQuantity() {
		System.out.println("Enter product name: ");
		String product_name = scanner.next();
		scanner.nextLine();
		System.out.println("Enter updated quantity: ");
		int product_quantity = scanner.nextInt();
		
		try {
			String update_query = "update inventory set product_quantity = ? where product_name = ?;";
			
			PreparedStatement update_quantity = connection.prepareStatement(update_query);
			update_quantity.setInt(1, product_quantity);
			update_quantity.setString(2, product_name);
			
			int affected = update_quantity.executeUpdate();

			if (affected > 0) {
				System.out.println("Quantity updated.");
			} else {
				System.out.println("Failed to update quantity!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeProduct() {
		System.out.println("Enter product ID: ");
		int product_id = scanner.nextInt();
		
		try {
			String remove_query = "delete from inventory where product_id = ?;";
			
			PreparedStatement remove_product = connection.prepareStatement(remove_query);
			remove_product.setInt(1, product_id);
			
			int affected = remove_product.executeUpdate();

			if (affected > 0) {
				System.out.println("Product deleted.");
			} else {
				System.out.println("Failed to delete product!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void viewProducts() {
		try {
			String view_query = "select * from inventory;";

			PreparedStatement view_products = connection.prepareStatement(view_query);
			ResultSet view_result = view_products.executeQuery();

			System.out.println();
			System.out.println("Products:");
			System.out.println("+------------+------------------------------------+----------+");
			System.out.println("| Product ID | Product Name                       | Quantity |");
			System.out.println("+------------+------------------------------------+----------+");

			while (view_result.next()) {
				int product_id = view_result.getInt("product_id");
				String product_name = view_result.getString("product_name");
				String product_quantity = view_result.getString("product_quantity");
			    System.out.format("| %-10d | %-34s | %-8s |\n", product_id, product_name, product_quantity);
				System.out.println("+------------+------------------------------------+----------+");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}