package com.inventoy_manager.features;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Manager {
	private static final String url = "jdbc:mysql://localhost:3306/inventory_manager";
	private static final String username = "root";
	private static final String password = "!1sqlp@ssword";


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Products product = new Products(scanner, connection);

			while (true) {
				System.out.println("Welcome to Smart Inventory Manager!");
				System.out.println("Please select what we need to manage today:");
				System.out.println();
				System.out.println("1] Add products");
				System.out.println("2] Update Quantity");
				System.out.println("3] Remove Product");
				System.out.println("4] View products");
				System.out.println("5] Exit");
				System.out.println();
				System.out.print("Select your choice: ");
				byte choice = scanner.nextByte();

				switch (choice) {

				case 1 -> {
					product.addProduct();
					System.out.println();
				}
				case 2 -> {
					product.updateQuantity();
					System.out.println();
				}
				case 3 -> {
					product.removeProduct();
					System.out.println();
				}
				case 4 -> {
					product.viewProducts();
					System.out.println();
				}
				case 5 -> {
					System.out.println();
					System.out.println("Thank you for using Smart Inventory Manager");
					return;
				}
				default -> System.out.println("Invalid choice!");

				}
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		scanner.close();
	}
}