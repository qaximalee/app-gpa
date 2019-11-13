package com.ihsinformatics.gpaconvertor.hbentities;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "semester_results")
public class SemesterResults {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "semester_results_id")
	private int semesterResultId;

	@OneToOne
	@JoinColumn(name = "semester_id")
	private Semester semester;

	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@Column(name = "semester_gpa")
	private double semesterGPA;

	@Column(name = "cgpa")
	private double cGPA;

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public SemesterResults(int semesterResultId, Semester semester, Student student, double semesterGPA, double cGPA) {
		super();
		this.semesterResultId = semesterResultId;
		this.semester = semester;
		this.student = student;
		this.semesterGPA = Double.parseDouble(df2.format(semesterGPA));
		this.cGPA = Double.parseDouble(df2.format(cGPA));
	}

	public SemesterResults() {
		// TODO Auto-generated constructor stub
	}

	public int getSemesterResultId() {
		return semesterResultId;
	}

	public void setSemesterResultId(int semesterResultId) {
		this.semesterResultId = semesterResultId;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
