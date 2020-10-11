package courses;
import java.util.ArrayList;
import java.util.Collections;

public class CourseList implements Cloneable, java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Course> courseList;
	
	public CourseList(){
		this.courseList = new ArrayList<Course>();
	}
	
	public int addCourse ( Course courseToAdd ) {
		try {
			courseList.add( courseToAdd );
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public int removeCourse ( int indexToRemove ) {
		try {
			courseList.remove( indexToRemove );
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public int size() {
		return courseList.size();
	}
	
	public Course get(int i) {
		return courseList.get(i);
	}
	
	public CourseList getAvailableCourses() {
		CourseList availableCourses = new CourseList();
		for(int i = 0; i < courseList.size(); i++) {
			if(!courseList.get(i).isFull()) {
				availableCourses.addCourse(courseList.get(i));
			}
		}
		return availableCourses;
	}

	public CourseList getFullCourses() {
		CourseList fullCourses = new CourseList();
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).isFull()) {
				fullCourses.addCourse(courseList.get(i));
			}
		}
		return fullCourses;
	}
	
	public CourseList sortByEnrollment() {
		try {
			CourseList sortedCourses = (CourseList)this.clone();
			Collections.sort(sortedCourses.courseList);
			return sortedCourses;
		} catch(Exception e) {
			return new CourseList();
		}
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += String.format("%-12s | %-45s | %-15s | %-25s | %-10s\n", "ID", "Course Name", "Section Number", "Instructor", "Open Seats");
		toReturn += "-".repeat(119) + "\n";
		// populate toReturn with student names
		for(int i = 0; i < courseList.size(); i++) {
			toReturn += String.format("%-12s | %-45s | %-15d | %-25s | %-10s \n", courseList.get(i).getId(), courseList.get(i).getName(), courseList.get(i).getSectionNumber(), courseList.get(i).getInstructor(), courseList.get(i).getOpenSeats());
		}
		return toReturn;
	} 

	public String toString(boolean admin) {
		String toReturn = "";
		toReturn += String.format("%-12s | %-45s | %-15s | %-25s | %-10s | %-10s\n", "ID", "Course Name", "Section Number", "Instructor", "Open Seats", "# Enrolled");
		toReturn += "-".repeat(132) + "\n";
		// populate toReturn with student names
		for(int i = 0; i < courseList.size(); i++) {
			toReturn += String.format("%-12s | %-45s | %-15d | %-25s | %-10s | %-10s\n", courseList.get(i).getId(), courseList.get(i).getName(), courseList.get(i).getSectionNumber(), courseList.get(i).getInstructor(), courseList.get(i).getOpenSeats(), courseList.get(i).getNumRegisteredStudents());
		}
		return toReturn;
	} 

	public Object clone()throws CloneNotSupportedException{  
		return (CourseList)super.clone();  
	}
}
