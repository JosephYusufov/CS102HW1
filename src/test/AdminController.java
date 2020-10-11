package test;

import java.util.Scanner; // Import the Scanner class
import java.util.ArrayList;
import courses.*;
import users.*;

public class AdminController {
	
	private Admin user;
	private CourseList courseDirectory;
	private ArrayList<Student> studentDirectory;
	
	public AdminController(Admin user, CourseList courseDirectory, ArrayList<Student> studentDirectory) {
		this.user = user;
		this.courseDirectory = courseDirectory;
		this.studentDirectory = studentDirectory;
	}
}
