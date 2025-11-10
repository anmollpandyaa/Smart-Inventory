package com.infy;

public class Customer {
	
	String customer_id;
	String customer_name;
	String customer_address;
	long contact_number;
	
	public void displayCustomerDetails() {
		System.out.println("Customer details:\n---------------");
		System.out.println("Customer Id: " + customer_id);
		System.out.println("Customer Name: " + customer_name);
		System.out.println("Customer contact no.: " + contact_number);
		System.out.println("Customer address: " + customer_address);
	}
	
	public void bill(double total_price, double discount_percentage) {
		double final_price = total_price * (1 - (discount_percentage / 100));
		System.out.println("Hi " + customer_name + ", your final bill amount after discount is: " + (int) (final_price * 100) / 100.0);
	}
	
	public Customer(String cid, String name, String address, long number) {
		this.customer_id = cid;
		this.customer_name = name;
		this.customer_address = address;
		this.contact_number = number;
	}

	public static void main(String[] args) {
		
		Customer c1 = new Customer("AP1", "Anmol", "Indore", 98762340);
		
		c1.displayCustomerDetails();
		c1.bill(50000, 20);
		
	}

}