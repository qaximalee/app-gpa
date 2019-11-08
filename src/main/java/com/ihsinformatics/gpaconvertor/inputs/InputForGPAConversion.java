package com.ihsinformatics.gpaconvertor.inputs;

import java.text.DecimalFormat;
import java.util.Scanner;

public class InputForGPAConversion {
	private int courseCode;
	private int semesterNo;
	private double percentage;

	public InputForGPAConversion() {
	}

	public InputForGPAConversion(int courseCode, int semesterNo, double percentage) {
		super();
		this.courseCode = courseCode;
		this.semesterNo = semesterNo;
		this.percentage = percentage;
	}

	public void initializeInputs() {
		DecimalFormat twoDecimalPoints = new DecimalFormat("#.##");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your Semester No: ");
		setSemesterNo(Integer.parseInt(scan.nextLine()));
		System.out.println("Enter Your Course Code: ");
		setCourseCode(Integer.parseInt(scan.nextLine()));
		System.out.println("Enter Your Percentage: ");
		double percentageInDouble = Double.parseDouble(scan.nextLine());
		double percentageValue = Double.parseDouble(twoDecimalPoints.format(percentageInDouble));
		setPercentage(percentageValue);
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
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
}
