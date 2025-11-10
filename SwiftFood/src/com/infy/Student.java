package com.infy;

public class Student {
	final String institute = "SVIIT";
	String name;
	int registration_id;

	public void getDetails() {
		System.out.println("Name: " + name + " Registration ID: " + registration_id + " Institute: " + institute);
	}

	Student(String name, int registration_id) {
		this.name = name;
		this.registration_id = registration_id;
	}

	public static void main(String[] args) {
		Student student1 = new Student("Rajeev", 1);

		student1.getDetails();

	}

}