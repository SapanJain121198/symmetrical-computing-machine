package com.lti.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.TestReport;

@Repository
public class ScoreCalculationDao extends GenericDao {
	
	public void ScoreUpdation(TestReport testReport, int score) {
		
		int updatedScore = testReport.getScore()+score;
		
		testReport.setScore(updatedScore);
		
		entityManager.merge(testReport);
		
	}
}
