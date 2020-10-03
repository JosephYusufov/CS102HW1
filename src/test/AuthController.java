package test;
import users.Student;
//import users.Admin;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;  

public class AuthController {
	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean active = true;
		
		ArrayList<Student> studentDirectory = new ArrayList<Student>();
		while(active) {
			System.out.println( "Welcome! Please enter your usename > " );

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
}
