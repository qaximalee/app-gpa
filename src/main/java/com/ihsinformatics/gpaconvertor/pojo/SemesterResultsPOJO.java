package com.ihsinformatics.gpaconvertor.pojo;

public class SemesterResultsPOJO {
	private int semesterResultId;
	private String firstName;
	private String lastName;
	private String registrationNo;
	private int semesterNo;
	private double semesterGPA;
	private double cGPA;

	public SemesterResultsPOJO(int semesterResultId, String firstName, String lastName, String registrationNo,
			int semesterNo, double semesterGPA, double cGPA) {
		super();
		this.semesterResultId = semesterResultId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationNo = registrationNo;
		this.semesterNo = semesterNo;
		this.semesterGPA = semesterGPA;
		this.cGPA = cGPA;
	}

	public int getSemesterResultId() {
		return semesterResultId;
	}

	public void setSemesterResultId(int semesterResultId) {
		this.semesterResultId = semesterResultId;
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

	public int getSemesterNo() {
		return semesterNo;
	}

	public void setSemesterNo(int semesterNo) {
		this.semesterNo = semesterNo;
	}

	public double getSemesterGPA() {
		return semesterGPA;
	}

	public void setSemesterGPA(double semesterGPA) {
		this.semesterGPA = semesterGPA;
	}

	public double getcGPA() {
		return cGPA;
	}

	public void setcGPA(double cGPA) {
		this.cGPA = cGPA;
	}
}
