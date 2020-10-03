package users;

public interface StudentInterface {
	public String getFirstName();
	public String getLastName();
	public String getUserName();
	public String getName();

	// move to StudentController
//	public void viewAllCourses();
	
	// move to StudentController
//	public void viewNotEmptyCourses();
	
	public void viewRegisteredCourses();
	

	// move to studentController
//	public int register( String courseName, int section, String studentNameInput );
//	public int withdraw( String courseName, String studentNameInput );	
}
