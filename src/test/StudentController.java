package test;

import java.util.Scanner; // Import the Scanner class
import java.util.regex.Pattern;

import courses.*;
import users.*;

public class StudentController {

	private Student user;
	private CourseList courseDirectory;
	
	public StudentController(Student user, CourseList courseDirectory) {
		this.user = user;
		this.courseDirectory = courseDirectory;
	}
	public void start() {
		
		Scanner scanner = new Scanner(System.in);
		boolean active = true;

//		Course math = new Course();
//		Course science = new Course();
//		science.setInstructor("Aneese Bari");
//
//		CourseList courseList = new CourseList();
//
//		courseList.addCourse(math);
//		courseList.addCourse(science);

		while (active) {
			System.out.println("Welcome " + user.getName() + " !\n");
//			System.out.println("-".repeat(20) + "\n");
			System.out.println("-".repeat(119));
			System.out.println(" ".repeat(47) + "Your Registered Courses" + " ".repeat(47));
			System.out.println("-".repeat(119));
			System.out.println(user.getRegisteredCourses());
//			System.out.println("--------------------------------------------");
			System.out.println("\n(0)Exit | (1)See All Courses | (2)See Available Courses | (3)Withdraw");
			System.out.print("> ");

			try {
				int isActive = scanner.nextInt();
				if (isActive == 0) {
					active = false;
				} else {
					active = true;
					switch (isActive) {
					case 1:
						System.out.println("-".repeat(119));
						System.out.println(" ".repeat(47) + "All Courses" + " ".repeat(47));
						System.out.println("-".repeat(119));
						System.out.println(courseDirectory);
						System.out.println("\n(0)Exit | (1)Back to Dashboard");
						System.out.print("> ");
						int option1 = scanner.nextInt();
						switch(option1) {
						case 0:
							active = false;
							break;
						default:
							break;
						}
						break;
					case 2:
						System.out.println("-".repeat(119));
						System.out.println(" ".repeat(47) + "Available Courses" + " ".repeat(47));
						System.out.println("-".repeat(119));
						System.out.println(courseDirectory.getAvailableCourses());
						System.out.println("\n(0)Exit | (1)Back to Dashboard | (2)Register in a Course");
						System.out.print("> ");
						int option2 = scanner.nextInt();
						switch(option2) {	
						case 0:
							active = false;
							break;
						case 2:
							System.out.print("\nEnter the name of the course you'd like to enroll in > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String courseNameToRegister = scanner.next();
//							scanner.useDelimiter(" ");
//							scanner.next();
							System.out.print("\nEnter the section you'd like to enroll in > ");
							int courseSectionToRegister = scanner.nextInt();
							
							System.out.print("\nEnter your name (First Last) to confirm > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String studentNameVerification = scanner.next();
							
							boolean result = registerInCourse(studentNameVerification, courseSectionToRegister, courseNameToRegister, user);
							
							if(result) {
								System.out.println("Success! You've enrolled in \"" + courseNameToRegister +  "\". Press enter to return to your dashboard.");
								if(scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							} else {
								System.out.println("Failed. Press enter to return to your dashboard.");
								if(scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							}

							break;
						default:
							break;
						}
						break;						
					case 3:
						System.out.print("\nEnter the name of the course that you'd like to withdraw from > ");
						scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
						String courseNameToWithdraw = scanner.next();
						System.out.print("\nEnter your name (First Last) to confirm > ");
						scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
						String nameVerificationToWithdraw = scanner.next();

						boolean resultWithdraw = withdrawFromCourse(nameVerificationToWithdraw, courseNameToWithdraw, user);
						
						if(resultWithdraw) {							
							System.out.println("Success, thank you. Press enter to return to your dashboard.");
							if(scanner.nextLine().equals("")) {
								scanner.nextLine();
							}
						} else {
							System.out.println("Failed. Try Again.");
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
	
	public boolean registerInCourse(String studentName, int sectionNumber, String courseName, Student user) {
		if(user.getName().equals(studentName)) {
			for(int i = 0; i < courseDirectory.size(); i++) {
				Course currentCourse = courseDirectory.get(i);
				
				if(currentCourse.getName().equals(courseName) && (currentCourse.getSectionNumber() == sectionNumber)) {
					try {
						user.register(currentCourse);
						currentCourse.addStudent(user);
						return true;
					} catch (Exception e) {
						System.out.println(e);
						return false;
					}					
				}
			}	
			return false;
		} else {
			return false;
		}
	}
	
	public boolean withdrawFromCourse(String studentName, String courseName, Student user) {
		if(user.getName().equals(studentName)) {
			try {
				user.withdraw(courseName);
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		} else {
			return false;
		}
	}
}