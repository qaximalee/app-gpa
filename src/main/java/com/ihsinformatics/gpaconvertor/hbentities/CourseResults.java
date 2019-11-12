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
@Table(name = "course_results")
public class CourseResults {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_result_id")
	private int courseResultId;

	@OneToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@Column(name = "percentage")
	private double percentage;

	@Column(name = "gpa")
	private double gpa;

	@Column(name = "grade")
	private String grade;

	@Column(name = "total_points")
	private double totalPoints;

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public CourseResults() {
	}

	public CourseResults(int courseResultId, Course course, Student student, double percentage, double gpa,
			String grade, double totalPoints) {
		super();
		this.courseResultId = courseResultId;
		this.course = course;
		this.student = student;
		this.percentage = percentage;
		this.gpa = Double.parseDouble(df2.format(gpa));
		this.grade = grade;
		this.totalPoints = Double.parseDouble(df2.format(totalPoints));
	}

	public int getCourseResultId() {
		return courseResultId;
	}

	public void setCourseResultId(int courseResultId) {
		this.courseResultId = courseResultId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = Double.parseDouble(df2.format(percentage));
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = Double.parseDouble(df2.format(gpa));
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
		this.totalPoints = Double.parseDouble(df2.format(totalPoints));
	}
}
