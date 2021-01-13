package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Answer")
public class Answer {

	@Id
	@GeneratedValue
	private int answerId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "reportId")
	private TestReport testReport;


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "questionId")
	private Question question;

	
	private int optionChosen;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getOptionChosen() {
		return optionChosen;
	}

	public void setOptionChosen(int optionChosen) {
		this.optionChosen = optionChosen;
	}

	public TestReport getTestReport() {
		return testReport;
	}

	public void setTestReport(TestReport testReport) {
		this.testReport = testReport;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
