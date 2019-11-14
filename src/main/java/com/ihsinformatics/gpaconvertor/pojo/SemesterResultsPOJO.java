package com.ihsinformatics.gpaconvertor.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SemesterResultsPOJO {

	@Id
	@Column(name = "semester_results_id")
	private int semesterResultsId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "registration_no")
	private String registrationNo;

	@Column(name = "semester_no")
	private int semesterNo;

	@Column(name = "semester_gpa")
	private double semesterGPA;

	@Column(name = "cgpa")
	private double cGPA;

	public SemesterResultsPOJO() {
	}

	public SemesterResultsPOJO(int semesterResultsId, String firstName, String lastName, String registrationNo,
			int semesterNo, double semesterGPA, double cGPA) {
		super();
		this.semesterResultsId = semesterResultsId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationNo = registrationNo;
		this.semesterNo = semesterNo;
		this.semesterGPA = semesterGPA;
		this.cGPA = cGPA;
	}

	public int getSemesterResultsId() {
		return semesterResultsId;
	}

	public void setSemesterResultsId(int semesterResultId) {
		this.semesterResultsId = semesterResultId;
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
