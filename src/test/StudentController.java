package test;

import java.util.Scanner; // Import the Scanner class
import courses.*;
import users.*;

public class StudentController {

	public void start(Student user) {
		Scanner scanner = new Scanner(System.in);
		boolean active = true;

		Course math = new Course();
		Course science = new Course();
		science.setInstructor("Aneese Bari");

		CourseList courseList = new CourseList();

		courseList.addCourse(math);
		courseList.addCourse(science);

		while (active) {
			System.out.println("Welcome " + user.getName() + " !\n");
//			System.out.println("-".repeat(20) + "\n");
			System.out.println("-".repeat(107));
			System.out.println(" ".repeat(40) + "Your Registered Courses" + " ".repeat(40));
			System.out.println("-".repeat(107));
			System.out.println(courseList);
//			System.out.println("--------------------------------------------");
			System.out.println("\n(0)Exit | (1)Register | (2)Withdraw");
			System.out.print("> ");

			try {
				int isActive = scanner.nextInt();
				if (isActive == 0) {
					active = false;
				} else {
					active = true;
					switch (isActive) {
					case 2:
						System.out.println("Please copy over the ID of the course that you'd like to withdraw from");
						System.out.print("> ");
						String idToWithdraw = scanner.next();
						System.out.println("Success, thank you. Press enter to return to your dashboard.");
						if(scanner.nextLine().equals("")) {
							scanner.nextLine();
						}
						break;
					default:
						System.out.println("Bye!");
					}
				}
			} catch (Exception e) {
				active = false;
				System.out.println(e);
			}
		}
		scanner.close();
	}
}