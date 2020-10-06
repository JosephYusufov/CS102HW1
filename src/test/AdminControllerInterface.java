package test;

import courses.Course;
import users.Student;

public interface AdminControllerInterface {
	public void start();
	//Course management 
	public Course createNewCourse();
	public void deleteCourse();
	public Student registerAStudent(Student student);
		// returns new student? 
	
	//Reports
	public void viewallCourses();
	public void viewAllFullCourses();
	public void viewNamesStudentsInCourse();
	
	
}
