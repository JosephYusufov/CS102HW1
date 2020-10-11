package users;

import java.util.UUID;

import courses.CourseList;

public class Admin extends User {

	// Fields
	// Constructors
	public Admin() {
		this.id = UUID.randomUUID().toString();
		this.firstName = "Admin";
		this.lastName = "";
		this.username = "Admin";
		this.password = "Admin001";
	}
}
