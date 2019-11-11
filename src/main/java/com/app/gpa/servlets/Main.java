package com.app.gpa.servlets;

import java.util.List;

import com.ihsinformatics.gpaconvertor.hbentities.Course;
import com.ihsinformatics.gpaconvertor.hbentities.Semester;
import com.ihsinformatics.gpaconvertor.hbservices.CourseDAO;
import com.ihsinformatics.gpaconvertor.hbservices.SemesterDAO;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;

public class Main {
	public static void main(String[] args) {

		HCrudOperations<Course> stdOprt = new CourseDAO();
		HCrudOperations<Semester> sem = new SemesterDAO();
		Course course = new Course(0, 4345, "Responsive Programming", sem.getSingle(1));
		Course course1 = new Course(0, 4411, "Reactive Programming", sem.getSingle(2));
		stdOprt.save(course);

		stdOprt.save(course1);

		List<Course> courses = stdOprt.getAll();

		for (Course crs : courses) {
			System.out.println("ID" + crs.getCourseId());
			System.out.println("Course Info: " + crs.getName() + " " + crs.getCourseCode());
			System.out.println("Semester Id: " + crs.getSemester().getSemesterNo());
			System.out.println();
		}
	}
}
