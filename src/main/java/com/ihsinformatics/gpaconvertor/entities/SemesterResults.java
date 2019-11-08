package com.ihsinformatics.gpaconvertor.entities;

import java.text.DecimalFormat;

public class SemesterResults {

	private int semesterResultId;
	private int semesterId;
	private int studentId;
	private double semesterGPA;
	private double cGPA;

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public SemesterResults(int semesterResultId, int semesterId, int studentId, double semesterGPA, double cGPA) {
		super();
		this.semesterResultId = semesterResultId;
		this.semesterId = semesterId;
		this.studentId = studentId;
		this.semesterGPA = Double.parseDouble(df2.format(semesterGPA));
		this.cGPA = Double.parseDouble(df2.format(cGPA));
	}

	public int getSemesterResultId() {
		return semesterResultId;
	}

	public void setSemesterResultId(int semesterResultId) {
		this.semesterResultId = semesterResultId;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getSemesterGPA() {
		return semesterGPA;
	}

	public void setSemesterGPA(double semesterGPA) {
		this.semesterGPA = Double.parseDouble(df2.format(semesterGPA));
	}

	public double getcGPA() {
		return cGPA;
	}

	public void setcGPA(double cGPA) {
		this.cGPA = Double.parseDouble(df2.format(cGPA));
	}
}
