package com.ihsinformatics.gpaconvertor.pojo;

public class CourseResultsPOJO {
	private int courseResultId;
	private String firstName;
	private String lastName;
	private String registrationNo;
	private String courseName;
	private int semesterNo;
	private double percentage;
	private double gpa;
	private String grade;
	private double totalPoints;

	public CourseResultsPOJO() {
	}

	public CourseResultsPOJO(int courseResultId, String firstName, String lastName, String registrationNo,
			String courseName, int semesterNo, double percentage, double gpa, String grade, double totalPoints) {
		super();
		this.courseResultId = courseResultId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationNo = registrationNo;
		this.courseName = courseName;
		this.semesterNo = semesterNo;
		this.percentage = percentage;
		this.gpa = gpa;
		this.grade = grade;
		this.totalPoints = totalPoints;
	}

	public int getCourseResultId() {
		return courseResultId;
	}

	public void setCourseResultId(int courseResultId) {
		this.courseResultId = courseResultId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
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
}
