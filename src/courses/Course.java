// TODO: Change ArrayList<String> to ArrayList<Student>

package courses;

import java.util.ArrayList; // import the ArrayList class

import users.*;

public class Course implements Comparable<Course>, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1234L;
	// Fields
	private String id;
	private String name;
	private String instructor;
	private String location;
	private int sectionNumber;
	private int maxStudents;
	private boolean isFull;
	private ArrayList<Student> registeredStudents;

	// Constructors
	public Course() {
		this.id = "CS102";
		this.name = "Default";
		this.instructor = "Mr. Smith";
		this.location = "New York City";
		this.sectionNumber = 0;
		this.maxStudents = 10;
		this.isFull = false;
		this.registeredStudents = new ArrayList<Student>();
	}

	public Course(String id, String name, String instructor, String location, int sectionNumber, int maxStudents) {
		this.id = id;
		this.name = name;
		this.instructor = instructor;
		this.location = location;
		this.sectionNumber = sectionNumber;
		this.maxStudents = maxStudents;
		this.isFull = false;
		this.registeredStudents = new ArrayList<Student>();
	}

	// String Representation
	public String toString() {
		String toReturn = "";
		toReturn += String.format("%32s | %-32s\n", "ID", this.id);
		toReturn += String.format("%32s | %-32s\n", "Course Name", this.name);
		toReturn += String.format("%32s | %-32s\n", "Instructor", this.instructor);
		toReturn += String.format("%32s | %-32s\n", "Location", this.location);
		toReturn += String.format("%32s | %-32d\n", "Section Number", this.sectionNumber);
		toReturn += String.format("%32s | %-32s\n", "Maximum Capacity", this.maxStudents);
		toReturn += String.format("%32s | %-32b\n", "Is Full?", this.isFull);
		toReturn += String.format("%32s | %-32s\n", "Registered Students", "");

		// populate toReturn with student names
		for (int i = 0; i < registeredStudents.size(); i++) {
			toReturn += String.format("%32s | %-32s\n", "", registeredStudents.get(i).getName());
		}
		return toReturn;
	}

	// Getter Methods
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInstructor() {
		return instructor;
	}

	public String getLocation() {
		return location;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public int getNumRegisteredStudents() {
		return registeredStudents.size();
	}

	public int getOpenSeats() {
		return (maxStudents - registeredStudents.size());
	}

	public boolean isFull() {
		if (registeredStudents.size() >= maxStudents) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Student> getRegisteredStudents() {
		return registeredStudents;
	}

	public String setInstructor(String newInstructor) {
		String oldInstructor = instructor;
		instructor = newInstructor;
		return oldInstructor;
	}

	public String setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		return oldLocation;
	}

	public int setSectionNumber(int newSectionNumber) {
		int oldSectionNumber = sectionNumber;
		sectionNumber = newSectionNumber;
		return oldSectionNumber;
	}

	public int setMaxStudents(int newMaxStudents) {
		int oldMaxStudents = maxStudents;
		maxStudents = newMaxStudents;
		return oldMaxStudents;
	}

	public String setName(String newName) {
		String oldName = name;
		name = newName;
		return oldName;
	}

	// returns 1 on success, 0 on failure
	public int addStudent(Student student) {
		if (registeredStudents.size() <= maxStudents) {
			registeredStudents.add(student);
			return 1;
		} else {
			return 0;
		}
	}

	// returns 1 on success, 0 on failure
	public int removeStudent(String studentName) {
		for (int i = 0; i < registeredStudents.size(); i++) {
			if (registeredStudents.get(i).getName().equals(studentName)) {
				registeredStudents.remove(i);
				return 1;
			}
		}
		return 0;
	}
	
	public int compareTo(Course courseToCompare) {
		return courseToCompare.getNumRegisteredStudents() - this.registeredStudents.size();
	}
}
