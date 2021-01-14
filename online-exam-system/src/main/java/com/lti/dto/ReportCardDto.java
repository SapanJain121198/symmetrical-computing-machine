package com.lti.dto;

public class ReportCardDto {
	
	private int userId;
	private String fullName;
	private int score;
	private int testLevel;
	private String testSubjectName;

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
