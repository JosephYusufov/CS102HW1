package test;

import users.*;
import courses.*;
import java.util.Scanner; // Import the Scanner class
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AuthController {
	
	protected ArrayList<Student> studentDirectory;
	protected CourseList courseDirectory;
	protected User user;
	
	public AuthController() {
		studentDirectory = new ArrayList<Student>();
		courseDirectory = new CourseList();
		user = null;
	}
	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean active = true;

		
		
		
		
		// This is where the serialization / deserialization will occur, 
		// as well as the reading from the CSV.
		
		String row = "";
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./src/data/MyUniversityCourses.csv"));
			csvReader.readLine();
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				Course newCourse = new Course(data[1], data[0], data[5], data[7], 
						Integer.parseInt(data[6]), Integer.parseInt(data[2]));				
				courseDirectory.addCourse(newCourse);
			}
			csvReader.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		Student s1 = new Student("Joseph", "Yusufov", "jyusufov", "password");
		Student s2 = new Student("Mike", "Pence", "mpence", "123123123");
		Student s3 = new Student("Kamala", "Harris", "kharris", "veep");
		Student s4 = new Student("Elizabeth", "Buckingham", "ebuckingham", "crumpets");
		
		studentDirectory.add(s1);
		studentDirectory.add(s2);
		studentDirectory.add(s3);
		studentDirectory.add(s4);
		
		while (active) {
			System.out.print("Welcome! Please enter your usename > ");
			String username = scanner.next();
			System.out.print("Password > ");
			String password = scanner.next();
			
			boolean result = authenticate(username, password);
//			System.out.println(result);
			
			if(result) {
				if(user instanceof Student) {
					StudentController studentController = new StudentController((Student)user, courseDirectory);
					studentController.start();
					active = false;
				} else {
					System.out.println("Welcome Admin");
					active = false;
				}
			} else {
				System.out.println("Incorrect username/password. Try again.");
			}
			
//			try {
//				String isActive = scanner.next();
//				if ( isActive == 0) {
//					active = false;
//				} else {
//					active = true;
//				}
//			} catch (Exception e) {
//				active = false;
//				System.out.println(e);
//			}
		}
		scanner.close();

	}
	
	public boolean authenticate(String username, String password) {
		if(username.equals("Admin") && password.equals("Admin001")) {
			Admin admin = new Admin();
			this.user = admin;
			return true;
		} else {
			for(int i = 0; i < studentDirectory.size(); i++) {
				if(studentDirectory.get(i).authenticate(username, password)) {
					this.user = studentDirectory.get(i);
					return true;
				}
			}
			return false;
		}
	}
	
}
