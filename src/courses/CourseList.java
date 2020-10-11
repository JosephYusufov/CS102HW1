package courses;
import java.util.ArrayList; 

public class CourseList {
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
}
