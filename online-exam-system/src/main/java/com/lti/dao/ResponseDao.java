package com.lti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Answer;
import com.lti.entity.Question;
import com.lti.entity.TestReport;

@Repository
public class ResponseDao extends GenericDao {
	
	// we have to update the "answer table" and save the user's response
	
	
		// We will create a report id at the beginning of the test itself
		// and we will  update the score and dateandtime of the test at the 
		// time of fining the test
	
	@Autowired
	private GenericDao genericDao;
	
	@Transactional
	public void saveResponse(int questionId, int reportId, int optionChosen) {
		
		Answer answer = new Answer();
		answer.setOptionChosen(optionChosen);
		answer.setTestReport(genericDao.fetchByKey(TestReport.class, reportId));
		answer.setQuestion(genericDao.fetchByKey(Question.class, questionId));
		
		genericDao.save(answer);
	
	}
	
}
