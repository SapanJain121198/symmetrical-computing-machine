package com.lti.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "UserReport")
public class TestReport {

	@Id
	@GeneratedValue
	private int reportId;
	
	private int score;
	private int testLevel;
	private String testSubjectName;
	private LocalDateTime dateAndTime;
	
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private RegisteredUser registeredUser;
	

	@JsonIgnore
	@OneToMany(mappedBy = "testReport", cascade= {CascadeType.REMOVE,CascadeType.PERSIST}) //persist because if we add a response then it will reflect in the report as well
	private List <Answer> answers;
	
	

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
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

	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	

}
