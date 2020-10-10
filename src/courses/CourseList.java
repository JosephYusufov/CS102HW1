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
	
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += String.format("%-36s | %-32s | %-20s | %-10s\n", "ID", "Course Name", "Instructor", "Open Seats");
		toReturn += "-".repeat(107) + "\n";
		// populate toReturn with student names
		for(int i = 0; i < courseList.size(); i++) {
			toReturn += String.format("%-36s | %-32s | %-20s | %-10s \n", courseList.get(i).getId(), courseList.get(i).getName(), courseList.get(i).getInstructor(), courseList.get(i).getOpenSeats());
		}
		return toReturn;
	} 
}
