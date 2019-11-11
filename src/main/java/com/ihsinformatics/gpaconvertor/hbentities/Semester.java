package com.ihsinformatics.gpaconvertor.hbentities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "semester")
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "semester_id")
	private int semesterId;

	@Column(name = "semester_no")
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
