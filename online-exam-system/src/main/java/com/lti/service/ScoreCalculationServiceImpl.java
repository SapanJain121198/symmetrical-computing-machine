package com.lti.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.ScoreCalculationDao;
import com.lti.entity.Question;
import com.lti.entity.TestReport;

@Service
public class ScoreCalculationServiceImpl implements ScoreCalculationService {
	

	@Autowired
	private ScoreCalculationDao scoreCalculateDao;
	
	
	@Transactional
	@Override
	public void ScoreCalcuation(int questionId, int optionChosen, int reportId) {
		
		int score = 0;
		
		Question question = scoreCalculateDao.fetchByKey(Question.class, questionId);
		TestReport testReport = scoreCalculateDao.fetchByKey(TestReport.class, reportId);
		
		if(question.getCorrectAnswer() == optionChosen) {
			
			score =3;
			scoreCalculateDao.ScoreUpdation(testReport , score);
		}
		
		else {
			score =0;
			scoreCalculateDao.ScoreUpdation(testReport , score);
			
		}
	}
}
