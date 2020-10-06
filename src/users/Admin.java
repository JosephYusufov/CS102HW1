package users;

import java.util.ArrayList;

import courses.Course;

public class Admin extends User implements AdminInterface {
	public Admin() {
		this.firstName = "John";
		this.lastName = "Doe";
		this.username = "Admin";
		this.password = "Admin001";
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getName() {
		return ( firstName + " " + lastName );
	}
	
	public void sort() {
		System.out.println("sort");
	}
	
}
