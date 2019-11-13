package com.app.gpa.servlets;

import java.util.List;

import com.ihsinformatics.gpaconvertor.hbservices.CourseResultsDAO;
import com.ihsinformatics.gpaconvertor.pojo.CourseResultsPOJO;

public class Main {

	public static void mains(String[] args) {

		CourseResultsDAO c = new CourseResultsDAO();

		List<CourseResultsPOJO> cr = c.getAllReadableResults();

		for (CourseResultsPOJO cp : cr) {
			System.out.println("Name: " + cp.getFirstName());
			System.out.println("Rg No: " + cp.getRegistrationNo());
			System.out.println("Semester: " + cp.getSemesterNo());
			System.out.println("Course: " + cp.getCourseName());
			System.out.println("GPA: " + cp.getGpa());
			System.out.println("GRADE: " + cp.getGrade());
		}
	}
}
