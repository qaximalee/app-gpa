package com.ihsinformatics.gpaconvertor.pojo;

public class Result {

	private int courseResultId;
	private int courseCode;
	private String courseName;
	private int semesterNo;
	private double percentage;
	private int creditHours;
	private double gpa;
	private String grade;
	private double totalPoints;
	private double semesterGPA;
	private double cgpa;

	public Result() {
	}

	public Result(int courseResultId, int courseCode, String courseName, int semesterNo, double percentage,
			int creditHours, double gpa, String grade, double totalPoints, double semesterGPA, double cgpa) {
		super();
		this.courseResultId = courseResultId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.semesterNo = semesterNo;
		this.percentage = percentage;
		this.creditHours = creditHours;
		this.gpa = gpa;
		this.grade = grade;
		this.totalPoints = totalPoints;
		this.semesterGPA = semesterGPA;
		this.cgpa = cgpa;
	}

	public int getCourseResultId() {
		return courseResultId;
	}

	public void setCourseResultId(int courseResultId) {
		this.courseResultId = courseResultId;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getSemesterNo() {
		return semesterNo;
	}

	public void setSemesterNo(int semesterNo) {
		this.semesterNo = semesterNo;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
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
		this.totalPoints = totalPoints;
	}

	public double getSemesterGPA() {
		return semesterGPA;
	}

	public void setSemesterGPA(double semesterGPA) {
		this.semesterGPA = semesterGPA;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
}
