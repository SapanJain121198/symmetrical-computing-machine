package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.entity.Answer;
import com.lti.entity.Question;
import com.lti.entity.TestReport;

@Repository
public class ResponseDao extends GenericDao {
	
	// we have to update the "answer table" and save the user's response
	
	
		// We will create a report id at the beginning of the test itself
		// and we will  update the score and dateandtime of the test at the 
		// time of fining the test
	
	public void saveResponse(Question question, TestReport testReport, int optionChosen) {
		
		Answer answer = new Answer();
		answer.setTestReport(testReport);
		answer.setQuestion(question);
		answer.setOptionChosen(optionChosen);
		
		GenericDao genericDao = new GenericDao();
		genericDao.save(answer);
	}
	
}
