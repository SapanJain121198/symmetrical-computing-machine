package com.lti.dto;


public class SearchStudentDto {
	private int testLevel;
	public int getTestLevel() {
		return testLevel;
	}
	public void setTestLevel(int testLevel) {
		this.testLevel = testLevel;
	}
	public String getTestSubjectName() {
		return testSubjectName;
	}
	public void setTestSubjectName(String testSubjectName) {
		this.testSubjectName = testSubjectName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private String testSubjectName;
	private String city;
	private String state;

}
