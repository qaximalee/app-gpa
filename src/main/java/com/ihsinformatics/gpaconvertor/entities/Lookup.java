package com.ihsinformatics.gpaconvertor.entities;

public class Lookup {
	private int lookupId;
	private String grade;
	private double startParcentage;
	private double endPercentage;
	private double gpa;

	public Lookup() {
	}

	public Lookup(int lookupId, String grade, double startParcentage, double endPercentage, double gpa) {
		super();
		this.lookupId = lookupId;
		this.grade = grade;
		this.startParcentage = startParcentage;
		this.endPercentage = endPercentage;
		this.gpa = gpa;
	}

	public int getLookupId() {
		return lookupId;
	}

	public void setLookupId(int lookupId) {
		this.lookupId = lookupId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getStartParcentage() {
		return startParcentage;
	}

	public void setStartParcentage(double startParcentage) {
		this.startParcentage = startParcentage;
	}

	public double getEndPercentage() {
		return endPercentage;
	}

	public void setEndPercentage(double endPercentage) {
		this.endPercentage = endPercentage;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
