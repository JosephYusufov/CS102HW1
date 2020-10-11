package test;

import courses.*;
import users.*;

public class Main {
	public static void main(String[] args) {
//		CourseList courseList = new CourseList();
//		Course math = new Course();
//		math.setInstructor("John Doe");
//		math.setSectionNumber(3);
//		math.setName("Mathematics 101");
//		Student joshDoe = new Student("Josh", "Doe", "jdoe", "Josh123");
//		joshDoe.register(math);
//		math.addStudent(joshDoe);
//		courseList.addCourse(math);
//		System.out.println(math);
//		math.removeStudent("Josh Doe");
//		System.out.println(math);

//		StudentController controller = new StudentController();
//		Student joshDoe = new Student("Josh", "Doe", "jdoe", "Josh123");
//		Course science = new Course();
//		science.setInstructor("Joseph Lemelin");
//		science.setName("Mechanical Minds");
//		joshDoe.register(science);
//		science.addStudent(joshDoe);
//		controller.start(joshDoe);
		
		AuthController controller = new AuthController();
		controller.start();
		
		
		
		
		
		
////		Code to keep the interactive shell going
//		Scanner scanner = new Scanner(System.in);
//		boolean active = true;
//		
//		while(active) {
//			System.out.print("\n>");
//			try {
//				int isActive = scanner.nextInt();
//				if ( isActive == 0) {
//					active = false;
//				} else {
//					active = true;
//				}
//			} catch (Exception e) {
//				active = false;
//				System.out.println(e);
//			}
//		}
//		scanner.close();
	}
}
