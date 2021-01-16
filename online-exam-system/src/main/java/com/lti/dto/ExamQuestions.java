package com.lti.dto;

import java.util.List;

import com.lti.entity.Question;
import com.lti.entity.TestReport;

public class ExamQuestions {
	
	private List<Question> questions;
	private int reportId;
	
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

}
