package users;

import courses.Course;
import courses.CourseList;

public interface AdminInterface {
	public String getFirstName();
	public String getLastName();
	public String getUsername();
	public String getId();
	public String getName();
	public boolean authenticate(String username, String password);

}
