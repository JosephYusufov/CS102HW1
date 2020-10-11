package test;

import java.util.Scanner; // Import the Scanner class
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;

import courses.*;
import users.*;
import java.io.*;

public class AdminController {

	private Admin user;
	private CourseList courseDirectory;
	private ArrayList<Student> studentDirectory;

	public AdminController(Admin user, CourseList courseDirectory, ArrayList<Student> studentDirectory) {
		this.user = user;
		this.courseDirectory = courseDirectory;
		this.studentDirectory = studentDirectory;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean active = true;

		while (active) {
			System.out.println("Welcome Admin!\n");
			System.out.println("(0)Exit | (1)Course Management | (2)Reports");
			System.out.print("> ");

			try {
				int isActive = scanner.nextInt();
				if (isActive == 0) {
					active = false;
				} else {
					active = true;
					switch (isActive) {
					case 1:
						System.out.println("(0)Exit");
						System.out.println("(1)Back");
						System.out.println("(2)Create a Course");
						System.out.println("(3)Delete a Course");
						System.out.println("(4)Edit a Course");
						System.out.println("(5)Display Course Info");
						System.out.println("(6)Register a Student");
						System.out.print("> ");
						int option1 = scanner.nextInt();
						switch (option1) {
						case 0:
							active = false;
							break;
						default:
							break;
						case 2:
							System.out.print("\nCourse ID > ");
//							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String courseIdToCreate = scanner.next();

							System.out.print("\nCourse Name > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String courseNameToCreate = scanner.next();

							System.out.print("\nCourse Instructor > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String courseInstructorToCreate = scanner.next();

							System.out.print("\nCourse Location > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String courseLocationToCreate = scanner.next();

							System.out.print("\nSection Number > ");
//							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							int courseSectionToCreate = scanner.nextInt();

							System.out.print("\nMaximum Number of Students > ");
//							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							int courseMaxStudentsToCreate = scanner.nextInt();

							Course newCourse = new Course(courseIdToCreate, courseNameToCreate,
									courseInstructorToCreate, courseLocationToCreate, courseSectionToCreate,
									courseMaxStudentsToCreate);

							try {
								courseDirectory.addCourse(newCourse);
								System.out.println("Success, thank you. Press enter to return to your dashboard.");
								if (scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							} catch (Exception e) {
								System.out.println(e);
							}
							break;
							
						case 3:
							System.out.print("\nEnter Course ID > ");
							String courseIdToDelete = scanner.next();
							
							System.out.print("\nEnter Course Section > ");
							int courseSectionToDelete = Integer.parseInt(scanner.next());

							boolean success = false;
							for(int i = 0; i < courseDirectory.size(); i++) {
								Course current = courseDirectory.get(i);
								if(current.getId().equals(courseIdToDelete) && current.getSectionNumber() == courseSectionToDelete) {
									courseDirectory.removeCourse(i);
									success = true;
									break;
								}
							}
							if(success) {
								System.out.println("Deleted course, thank you. Press enter to return to your dashboard.");
								if (scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							} else {
								System.out.println("Failed, could not find a course with the ID \"" + courseIdToDelete + "\", section " + courseSectionToDelete + ". Press enter to return to your dashboard.");
								if (scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							}

							break;
						case 4:
							System.out.print("\nEnter Course ID > ");
							String courseIdToEdit = scanner.next();
							Course courseToEdit = null;
							for(int i = 0; i < courseDirectory.size(); i++) {
								Course current = courseDirectory.get(i);
								if(current.getId().equals(courseIdToEdit)) {
									courseToEdit = current;
								}
							}
							
							if(courseToEdit == null) {
								System.out.println("No Course found with the ID \"" + courseIdToEdit + "\". Press enter to return to your dashboard.");
								if (scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							} else {
								System.out.print("\nNew Instructor (\"n/a\" to leave the same) > ");
								scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
								String newInstructor = scanner.next();
								if(!newInstructor.equals("n/a")) {
									courseToEdit.setInstructor(newInstructor);
								}									

								
								System.out.print("\nNew Location (\"n/a\" to leave the same) > ");
								scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
								String newLocation = scanner.next();
								if(!newLocation.equals("n/a")) {
									courseToEdit.setLocation(newLocation);
								}

								System.out.print("\nNew Section Number (\"n/a\" to leave the same) > ");
								String newSectionNumber= scanner.next();
								if(!newSectionNumber.equals("n/a")) {
									try{
										int newSectionNumberParsed = Integer.parseInt(newSectionNumber);
										courseToEdit.setSectionNumber(newSectionNumberParsed);
									} catch(Exception e) {
										
									}
								}

								System.out.print("\nNew Max Capacity (\"n/a\" to leave the same) > ");
								String newMaxCapacity = scanner.next();
								if(!newMaxCapacity.equals("n/a")) {
									try{
										int newMaxCapacityParsed = Integer.parseInt(newMaxCapacity);
										courseToEdit.setMaxStudents(newMaxCapacityParsed);
									} catch(Exception e) {
										
									}
								}
							}

							break;
						case 5:
							System.out.print("\nEnter Course ID > ");
							String courseIdToView = scanner.next();
							Course courseToView = null;
							for(int i = 0; i < courseDirectory.size(); i++) {
								Course current = courseDirectory.get(i);
								if(current.getId().equals(courseIdToView)) {
									courseToView = current;
								}
							}
							
							if(courseToView == null) {
								System.out.println("Failed, could not find a course with the ID \"" + courseIdToView + "\". Press enter to return to your dashboard.");
								if (scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							} else {
								System.out.println(courseToView);
								System.out.println("(0)Exit | (1)Back to Dashboard");
								System.out.print("> ");
								int thisOption = scanner.nextInt();
								if(thisOption == 0) {
									active = false;
								}
							}
							break;
						case 6:
							
							System.out.print("\nFirst Name > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String studentFirstNameToCreate = scanner.next();

							System.out.print("\nLast Name > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String studentLastNameToCreate = scanner.next();

							System.out.print("\nUsername > ");
							String studentUsernameToCreate = scanner.next();

							System.out.print("\nPassword > ");
							String studentPasswordToCreate = scanner.next();

							Student newStudent = new Student(
								studentFirstNameToCreate, 
								studentLastNameToCreate,
								studentUsernameToCreate,
								studentPasswordToCreate
							);

							try {
								studentDirectory.add(newStudent);
								System.out.println("Successfully registered student. Press enter to return to your dashboard.");
								if (scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							} catch (Exception e) {
								System.out.println(e);
							}
							
							break;
						case 10:
							printStudentList(studentDirectory);
							break;
						}
					case 2:
						System.out.println("(0)Exit");
						System.out.println("(1)Back");
						System.out.println("(2)View All Courses");
						System.out.println("(3)View Full Courses");
						System.out.println("(4)Export Full Courses");
						System.out.println("(5)View Students By Course");
						System.out.println("(6)View Courses By Student");
						System.out.println("(7)Sort By Number of Students Registerred");
						System.out.print("> ");
						int option2 = scanner.nextInt();
						switch (option2) {
						case 0:
							active = false;
							break;
						case 2:
							System.out.println("-".repeat(119));
							System.out.println(" ".repeat(47) + "All Courses" + " ".repeat(47));
							System.out.println("-".repeat(119));
							System.out.println(courseDirectory);
							System.out.println("\n(0)Exit | (1)Back to Dashboard");
							System.out.print("> ");
							int option3 = scanner.nextInt();
							switch (option3) {
							case 0:
								active = false;
								break;
							default:
								break;
							}
							break;
						case 3:
							System.out.println("-".repeat(119));
							System.out.println(" ".repeat(47) + "Full Courses" + " ".repeat(47));
							System.out.println("-".repeat(119));
							System.out.println(courseDirectory.getFullCourses());
							System.out.println("\n(0)Exit | (1)Back to Dashboard");
							System.out.print("> ");
							int option4 = scanner.nextInt();

							switch (option4) {
							case 0:
								active = false;
								break;
							default:
								break;
							}
							break;
						case 4:
							exportFullCourses();
							System.out.println("Saved full courses as CSV to /src/data/FullCourses.csv. Press enter to return to Dashboard.");
							if (scanner.nextLine().equals("")) {
								scanner.nextLine();
							}

							break;
						case 5:
							ArrayList<Student> studentsInCourse = new ArrayList<Student>();
							System.out.print("\nCourse Name > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String courseName = scanner.next();
							
							ArrayList<Student> registeredStudents = getStudentsInCourse(courseName);
							
							if(registeredStudents.size() == 0) {
								System.out.println("No students in the queried course. Press enter to return to dashboard.");
								if (scanner.nextLine().equals("")) {
									scanner.nextLine();
								}
							} else {
								System.out.println("-".repeat(112));
								System.out.println(" ".repeat(10) + "STUDENTS IN COURSE: \"" + courseName + "\"");
								System.out.println("-".repeat(112));								
								printStudentList(registeredStudents);
							}
							break;
						case 6:
							CourseList coursesOfStudent = new CourseList();
							System.out.print("\nStudent Name (First Last) > ");
							scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
							String studentName = scanner.next();
							
							CourseList registeredCourses = getCoursesOfStudent(studentName);
							
							if(registeredCourses.size() == 0) {
								System.out.println("No courses for the queried student. Press enter to return to dashboard.");
								if (scanner.nextLine().equals("")) {
									scanner.nextLine();
								} 
							} else {
								System.out.println("-".repeat(119));
								System.out.println(" ".repeat(20) + "COURSES FOR STUDENT: \"" + studentName + "\"");
								System.out.println("-".repeat(119));
								System.out.println(registeredCourses);
							}

							break;
						case 7:
							System.out.println("-".repeat(132));
							System.out.println(" ".repeat(55) + "COURSES BY STUDENT ENROLLEMNT");
							System.out.println("-".repeat(132));
							System.out.println(courseDirectory.sortByEnrollment().toString(true));
							break;
						default:
							break;
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

	public void exportFullCourses() {
		try {
			FileWriter csvWriter = new FileWriter("./src/data/FullCourses.csv");
			csvWriter.append("ID");
			csvWriter.append(",");
			csvWriter.append("Name");
			csvWriter.append(",");
			csvWriter.append("Instructor");
			csvWriter.append(",");
			csvWriter.append("Location");
			csvWriter.append(",");
			csvWriter.append("Section Number");
			csvWriter.append(",");
			csvWriter.append("Max Students");
			csvWriter.append("\n");
			
			for(int i = 0; i < courseDirectory.getFullCourses().size(); i++) {
				Course course = courseDirectory.getFullCourses().get(i);
				csvWriter.append(course.getId());
				csvWriter.append(",");
				csvWriter.append(course.getName());
				csvWriter.append(",");
				csvWriter.append(course.getInstructor());
				csvWriter.append(",");
				csvWriter.append(course.getLocation());
				csvWriter.append(",");
				csvWriter.append(Integer.toString(course.getSectionNumber()));
				csvWriter.append(",");
				csvWriter.append(Integer.toString(course.getMaxStudents()));
				csvWriter.append("\n");				
			}
			
			csvWriter.flush();
			csvWriter.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void printStudentList(ArrayList<Student> studentList) {
		String toReturn = "";
		toReturn += String.format("%-36s | %-50s | %-20s\n", "ID", "Name", "Username");
		toReturn += "-".repeat(112) + "\n";
		
		// populate toReturn with student names
		for(int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			toReturn += String.format("%-36s | %-50s | %-20s\n", student.getId() , student.getName(), student.getUsername());
		}
		System.out.println(toReturn);

	}
	
	public ArrayList<Student> getStudentsInCourse(String courseName){
		ArrayList<Student> toReturn = new ArrayList<Student>();
		for(int i = 0; i < courseDirectory.size(); i++) {
			Course current = courseDirectory.get(i);
			if(current.getName().equals(courseName)) {
				for(int j = 0; j < current.getNumRegisteredStudents(); j++) {
					ArrayList<Student> registeredStudents = current.getRegisteredStudents();
					toReturn.addAll(registeredStudents);
				}
			}
		}
		return toReturn;
	}
	
	public CourseList getCoursesOfStudent (String studentName) {
		// Find correct student by name
		Student queryStudent = new Student();
		for(int i = 0; i < studentDirectory.size(); i++) {
			Student current = studentDirectory.get(i);
			if(current.getName().equals(studentName)) {
				queryStudent = current;
				break;
			}
		}
		CourseList registeredCourses = queryStudent.getRegisteredCourses();
		return registeredCourses;
	}
}
