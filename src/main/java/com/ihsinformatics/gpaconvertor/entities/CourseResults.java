package com.ihsinformatics.gpaconvertor.entities;

import java.text.DecimalFormat;

public class CourseResults {
	private int courseResultId;
	private int courseId;
	private int studentId;
	private double percentage;
	private double gpa;
	private String grade;
	private double totalPoints;

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public CourseResults() {
	}

	public CourseResults(int courseResultId, int courseId, int studentId, double percentage, double gpa, String grade,
			double totalPoints) {
		super();
		this.courseResultId = courseResultId;
		this.courseId = courseId;
		this.studentId = studentId;
		this.percentage = percentage;
		this.gpa = Double.parseDouble(df2.format(gpa));
		this.grade = grade;
		this.totalPoints = Double.parseDouble(df2.format(totalPoints));
	}

	public int getCourseResultId() {
		return courseResultId;
	}

	public void setCourseResultId(int courseResultId) {
		this.courseResultId = courseResultId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = Double.parseDouble(df2.format(percentage));
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = Double.parseDouble(df2.format(gpa));
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(double totalPoints) {
		this.totalPoints = Double.parseDouble(df2.format(totalPoints));
	}
}
