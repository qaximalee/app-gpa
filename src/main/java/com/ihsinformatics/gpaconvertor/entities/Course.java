package com.ihsinformatics.gpaconvertor.entities;

public class Course {
	private int courseId;
	private int courseCode;
	private String name;
	private int semesterId;

	public Course() {
	}

	public Course(int courseId, int courseCode, String name, int semesterId) {
		super();
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.name = name;
		this.semesterId = semesterId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

}
