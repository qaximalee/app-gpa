package com.ihsinformatics.gpaconvertor.entities;

public class Semester {
	private int semesterId;
	private int semesterNo;

	public Semester() {
	}

	public Semester(int semesterId, int semesterNo) {
		super();
		this.semesterId = semesterId;
		this.semesterNo = semesterNo;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public int getSemesterNo() {
		return semesterNo;
	}

	public void setSemesterNo(int semesterNo) {
		this.semesterNo = semesterNo;
	}

}
