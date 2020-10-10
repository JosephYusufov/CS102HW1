package users;
import java.util.ArrayList; // import the ArrayList class
import java.util.UUID;

import courses.Course;

public class Student extends User {
	
	// Fields
	private final static int maxCourses = 5;
	private ArrayList<Course> registeredCourses;
	
	// Constructors
	public Student() {
		this.id = UUID.randomUUID().toString();
		this.firstName = "John";
		this.lastName = "Doe";
		this.username = "username";
		this.password = "password";
		this.registeredCourses = new ArrayList<Course>();
	}
	
	public Student( String firstName, String lastName, String username, String password ) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.registeredCourses = new ArrayList<Course>();
	}

	// Methods
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
	
	public void viewRegisteredCourses() {
		System.out.println("Course");
	}
			
	public boolean register(Course courseToRegister) {
		if(!courseToRegister.isFull()) {
			registeredCourses.add(courseToRegister);
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String toReturn = "";
		toReturn += String.format("%32s | %-32s\n", "ID", this.id);
		toReturn += String.format("%32s | %-32s\n", "First Name", this.firstName);
		toReturn += String.format("%32s | %-32s\n", "Last Name", this.lastName);
		toReturn += String.format("%32s | %-32s\n", "Username", this.username);
		toReturn += String.format("%32s | %-32s\n", "Registered Classes", "");
		for (int i = 0; i < registeredCourses.size(); i++) {
			toReturn += String.format("%32s | %-32s\n", "", registeredCourses.get(i).getName());
		}
		return toReturn;
	}
}
