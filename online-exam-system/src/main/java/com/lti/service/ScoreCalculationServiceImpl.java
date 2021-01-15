package com.lti.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.ScoreCalculationDao;
import com.lti.entity.Question;
import com.lti.service.ExamServiceImpl;

@Service
public class ScoreCalculationServiceImpl implements ScoreCalculationService {
	

	@Autowired
	private ScoreCalculationDao scoreCalculateDao;
	
	@Autowired 
	private ExamServiceImpl examService;
	
	@Transactional
	@Override
	public void ScoreCalcuation(int questionId, int optionChosen) {
		
		int score = 0;
		
		Question question = scoreCalculateDao.fetchByKey(Question.class, questionId);
		
		if(question.getCorrectAnswer() == optionChosen) {
			
			score =3;
			scoreCalculateDao.ScoreUpdation(examService.reportId , score);
		}
	}
}
