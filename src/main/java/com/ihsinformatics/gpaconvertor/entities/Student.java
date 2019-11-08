package com.ihsinformatics.gpaconvertor.entities;

public class Student {
	private int studentId;
	private String registrationNo;
	private String firstName;
	private String lastName;

	public Student() {
	}

	public Student(int studentId, String registrationNo, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.registrationNo = registrationNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", registrationNo=" + registrationNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
}
