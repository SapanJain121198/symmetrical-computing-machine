package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userReport")
public class TestReport {

	@Id
	@GeneratedValue
	private int reportId;
	
	private String name;
	private int score;
	private int testLevel;
	private String testSubjectName;
	private int userId;
	private LocalDate dateAndTime;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public LocalDate getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDate dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

}
