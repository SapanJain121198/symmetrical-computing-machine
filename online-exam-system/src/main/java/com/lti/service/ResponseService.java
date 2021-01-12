package com.lti.service;

import com.lti.entity.Question;
import com.lti.entity.TestReport;

public interface ResponseService {
	
	public void saveResponse(Question question, TestReport testReport, int optionChosen);

}
