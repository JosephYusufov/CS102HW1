package users;

import java.util.UUID;

import courses.CourseList;

public class Admin extends User implements AdminInterface {

	// Fields
	// Constructors
	public Admin() {
		this.id = UUID.randomUUID().toString();
		this.firstName = "Admin";
		this.lastName = "";
		this.username = "Admin";
		this.password = "Admin001";
	}
	
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
	
	public boolean authenticate(String username, String password) {
		if ((username.equals(this.username)) && (password.equals(this.password))) {
			return true;
		} else {
			return false;
		}
	}
}
