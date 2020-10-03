package test;
import java.util.Scanner;  // Import the Scanner class
import courses.Course;
import courses.CourseList;

public class StudentController {

	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean active = true;
		
		Course math = new Course();
		Course science = new Course();
		science.setInstructor("Aneese Bari");
		
		CourseList courseList = new CourseList();
		
		courseList.addCourse( math );
		courseList.addCourse( science );
		
		while(active) {
			System.out.println( courseList );

			try {
				int isActive = scanner.nextInt();
				if ( isActive == 0) {
					active = false;
				} else {
					active = true;
				}
			} catch (Exception e) {
				active = false;
				System.out.println(e);
			}
		}
		scanner.close();		
	}
}