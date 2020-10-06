package test;
import courses.Course;
import java.util.Scanner;  // Import the Scanner class

public class Main {
	public static void main (String[] args) {
		
//		Course sampleCourse = new Course();
//		sampleCourse.addStudent("Yuriy Gagarin");
//		sampleCourse.addStudent("John Smith");
//		sampleCourse.addStudent("Jane Doe");		
//		System.out.println( sampleCourse );
//		sampleCourse.removeStudent("Jane Doe");
//		System.out.println( sampleCourse );
//
		
		
		StudentController studentController = new StudentController();
		studentController.start();
		
		
		
		
		
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
