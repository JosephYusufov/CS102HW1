package test;

import users.*;
import courses.*;
import java.util.Scanner; // Import the Scanner class
import java.io.*;
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

		if (!deserialize()) {
			System.out.println("First time launch...");
			String row = "";
			try {
				BufferedReader csvReader = new BufferedReader(new FileReader("./src/data/MyUniversityCourses.csv"));
				csvReader.readLine();
				while ((row = csvReader.readLine()) != null) {
					String[] data = row.split(",");
					Course newCourse = new Course(data[1], data[0], data[5], data[7], Integer.parseInt(data[6]),
							Integer.parseInt(data[2]));
					courseDirectory.addCourse(newCourse);
				}
				csvReader.close();
			} catch (Exception e) {
				System.out.println(e);
			}

			Course science = new Course("SCI-UA", "Applied Sciences", "James Appleseed", "Brooklyn", 1, 10);
			courseDirectory.addCourse(science);

			Student s1 = new Student("Joseph", "Yusufov", "jyusufov", "password");
			Student s2 = new Student("Mike", "Pence", "mpence", "123123123");
			Student s3 = new Student("Kamala", "Harris", "kharris", "veep");
			Student s4 = new Student("Elizabeth", "Buckingham", "ebuckingham", "crumpets");

			studentDirectory.add(s1);
			studentDirectory.add(s2);
			studentDirectory.add(s3);
			studentDirectory.add(s4);

			science.addStudent(s1);
			science.addStudent(s2);
			science.addStudent(s3);
			science.addStudent(s4);

			s1.register(science);
			s2.register(science);
			s3.register(science);
			s4.register(science);
		}

		while (active) {
			System.out.print("Welcome! Please enter your usename > ");
			String username = scanner.next();
			System.out.print("Password > ");
			String password = scanner.next();

			boolean result = authenticate(username, password);

			if (result) {
				if (user instanceof Student) {
					StudentController studentController = new StudentController((Student) user, courseDirectory);
					studentController.start();
					active = false;
				} else {
					AdminController adminController = new AdminController((Admin) user, courseDirectory,
							studentDirectory);
					adminController.start();
					active = false;
				}
			} else {
				System.out.println("Incorrect username/password. Try again.");
			}
		}

		serialize();
		scanner.close();
	}

	public boolean authenticate(String username, String password) {
		if (username.equals("Admin") && password.equals("Admin001")) {
			Admin admin = new Admin();
			this.user = admin;
			return true;
		} else {
			for (int i = 0; i < studentDirectory.size(); i++) {
				if (studentDirectory.get(i).authenticate(username, password)) {
					this.user = studentDirectory.get(i);
					return true;
				}
			}
			return false;
		}
	}

	public boolean serialize() {
		File studentDirectoryFile = new File("StudentDirectory.ser");
		if(!studentDirectoryFile.exists()) {
			try{
				studentDirectoryFile.createNewFile();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		
		File courseDirectoryFile = new File("CourseDirectory.ser");
		if(!courseDirectoryFile.exists()) {
			try{
				courseDirectoryFile.createNewFile();
			} catch(Exception e) {
				System.out.println(e);
			}
		}

		try {
			// FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("CourseDirectory.ser");

			// ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Writes the specific object to the OOS
			oos.writeObject(courseDirectory);

			// Close both streams
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try {
			// FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("StudentDirectory.ser");

			// ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Writes the specific object to the OOS
			oos.writeObject(studentDirectory);

			// Close both streams
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("Serialization complete");
		return true;
	}

	public boolean deserialize() {

		File studentDirectoryFile = new File("StudentDirectory.ser");
		File courseDirectoryFile = new File("CourseDirectory.ser");

		if (studentDirectoryFile.exists() && courseDirectoryFile.exists()) {
			System.out.println("Deserializing...");
			CourseList deserializedCourseDirectory;
			ArrayList<Student> deserializedStudentDirectory;

			try {
				// FileInputSystem recieves bytes from a file
				FileInputStream fis = new FileInputStream("CourseDirectory.ser");

				// ObjectInputStream does the deserialization-- it reconstructs the data into an
				// object
				ObjectInputStream ois = new ObjectInputStream(fis);

				// Cast as Employee. readObject will take the object from ObjectInputStream
				deserializedCourseDirectory = (CourseList) ois.readObject();
				ois.close();
				fis.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return false;
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
				return false;
			}

			try {
				// FileInputSystem recieves bytes from a file
				FileInputStream fis = new FileInputStream("StudentDirectory.ser");

				// ObjectInputStream does the deserialization-- it reconstructs the data into an
				// object
				ObjectInputStream ois = new ObjectInputStream(fis);

				// Cast as Employee. readObject will take the object from ObjectInputStream
				deserializedStudentDirectory = (ArrayList) ois.readObject();
				ois.close();
				fis.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return false;
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
				return false;
			}

			courseDirectory = deserializedCourseDirectory;
			studentDirectory = deserializedStudentDirectory;
			return true;
		} else {
			return false;
		}
	}

	public void printStudentList(ArrayList<Student> studentList) {
		String toReturn = "";
		toReturn += String.format("%-36s | %-50s | %-20s\n", "ID", "Name", "Username");
		toReturn += "-".repeat(112) + "\n";

		// populate toReturn with student names
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			toReturn += String.format("%-36s | %-50s | %-20s\n", student.getId(), student.getName(),
					student.getUsername());
		}
		System.out.println(toReturn);

	}

}
