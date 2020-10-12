package users;

import courses.Course;
import courses.CourseList;

public interface StudentInterface {
	public String getFirstName();
	public String getLastName();
	public String getUsername();
	public String getId();
	public String getName();
	public CourseList getRegisteredCourses();
	public boolean register(Course courseToRegister);
	public boolean withdraw(String courseName);
	public String toString();
	public boolean authenticate(String username, String password);
}
