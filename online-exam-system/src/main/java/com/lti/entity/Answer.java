package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer {
	
	@Id
	@GeneratedValue
	private int answerId;
	
	private int reportId;
	private int questionId;
	private int optionChosen;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getOptionChosen() {
		return optionChosen;
	}
	public void setOptionChosen(int optionChosen) {
		this.optionChosen = optionChosen;
	}
}
