package users;
import java.util.ArrayList; // import the ArrayList class
import courses.Course;

public class Student extends User implements StudentInterface {
	
	// Fields
	private final static int maxCourses = 5;
	private ArrayList<Course> registeredCourses;
	
	// Constructors
	public Student() {
		this.firstName = "John";
		this.lastName = "Doe";
		this.username = "username";
		this.password = "password";
		this.registeredCourses = new ArrayList<Course>();
	}
	
	public Student( String firstName, String lastName, String username, String password ) {
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
			
}
