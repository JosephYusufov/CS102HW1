package users;

import java.util.ArrayList; // import the ArrayList class
import java.util.UUID;

import courses.*;

public class Student extends User implements java.io.Serializable, StudentInterface{

	private static final long serialVersionUID = 123L;
	// Fields
	private final static int maxCourses = 5;
	private CourseList registeredCourses;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String id;
	
	// Constructors
	public Student() {
		this.id = UUID.randomUUID().toString();
		this.firstName = "John";
		this.lastName = "Doe";
		this.username = "username";
		this.password = "password";
		this.registeredCourses = new CourseList();
	}

	public Student(String firstName, String lastName, String username, String password) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.registeredCourses = new CourseList();
	}

	// Methods
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return (firstName + " " + lastName);
	}

	public CourseList getRegisteredCourses() {
		return registeredCourses;
	}

	public boolean register(Course courseToRegister) {
		if (!courseToRegister.isFull()) {
			registeredCourses.addCourse(courseToRegister);
			return true;
		} else {
			return false;
		}
	}

	public boolean withdraw(String courseName) {
		for (int i = 0; i < registeredCourses.size(); i++) {
			Course currentCourse = registeredCourses.get(i);
			
			if(currentCourse.getName().equals(courseName)) {
				registeredCourses.removeCourse(i);
				currentCourse.removeStudent(this.getName());
				return true;
			}
		}
		return false;
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

	public boolean authenticate(String username, String password) {
		if ((username.equals(this.username)) && (password.equals(this.password))) {
			return true;
		} else {
			return false;
		}
	}
}
