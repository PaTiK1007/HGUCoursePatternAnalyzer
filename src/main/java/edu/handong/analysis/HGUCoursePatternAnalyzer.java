package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Algorithm Analysis",
						"2019-1, SJ Kim, Logic Design"
						};
	
	int numOfStudents;
	int numOfCourses;
	Student[] students ;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		String name;
		Student[] test = new Student[numOfStudents];
		int i=0;
		// TODO: implement this method
		
		for(String student : lines) {
			
			name=student.trim().split(", ")[1];
			test[i]=new Student(name);
			
			if(i<numOfStudents-1||studentExist(test, test[i])==false) {
				i++;
			}else {
				i--;
			}
		}	
		
		return test;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		for(Student e: students) {
			
			if(e.getName() == student.getName()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		String course;
		Course[] test = new Course[numOfCourses];
		int i=0;
		// TODO: implement this method
		
			for(String courses : lines) {
			
			course=courses.trim().split(", ")[2];
			test[i]=new Course(course);
			
			if(i<numOfCourses-1||courseExist(test, test[i])==false) {
				i++;
			}else {
				i--;
			}
		}
		
		
		return test;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		for(Course e: courses) {
			
			if(e.getCourseName() == course.getCourseName()) {
				return true;
			}
		}
	
		return false;
	}

}
