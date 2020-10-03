package test;

public interface StudentControllerInterface {
	public void start();
	public void viewAllCourses();
	public void viewNotEmptyCourses();

	// Make student confirm their own name, and not another student's
	public int register( String courseName, int section, String studentNameInput, String studentName );
	public int withdraw( String courseName, String studentNameInput, String studentName );	
}
