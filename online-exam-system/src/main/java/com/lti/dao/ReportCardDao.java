package com.lti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.ReportCardDto;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;


@Repository
public class ReportCardDao extends GenericDao{
	
	@Autowired
	private GenericDao genericDao;
	

	public ReportCardDto generateReport(int userId, int reportId ) {
		
		//reportId = 1;
		
		ReportCardDto reportCard = new ReportCardDto();
		
		reportCard.setFullName((genericDao.fetchByKey(RegisteredUser.class, userId)).getFullName());
		
		reportCard.setScore((genericDao.fetchByKey(TestReport.class, reportId)).getScore());
		
		reportCard.setTestLevel((genericDao.fetchByKey(TestReport.class, reportId)).getTestLevel());
		
		reportCard.setTestSubjectName((genericDao.fetchByKey(TestReport.class, reportId)).getTestSubjectName());
		
		return reportCard;
	}

}
