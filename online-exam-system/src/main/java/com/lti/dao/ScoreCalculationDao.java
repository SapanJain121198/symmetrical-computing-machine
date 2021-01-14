package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.entity.TestReport;

@Repository
public class ScoreCalculationDao extends GenericDao {
	

	
	public void ScoreUpdation(int reportId, int score) {
		
		GenericDao genericDao = new GenericDao();
		
		TestReport testReport = genericDao.fetchByKey(TestReport.class, reportId);
		
		testReport.setScore(score);
		
		entityManager.merge(testReport);
		
	}
	
}
