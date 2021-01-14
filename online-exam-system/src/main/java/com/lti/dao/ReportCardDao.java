package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.dto.ReportCardDto;


@Repository
public class ReportCardDao extends GenericDao{
	

	public ReportCardDto generateReport(int userId, int reportId ) {
		// TODO Auto-generated method stub
		return (ReportCardDto) entityManager.createQuery("select  r.fullName, t.score, t.testLevel, t.testSubjectName from TestReport t join t.registeredUser r where r.userId = :userId and t.reportId =  :reportId")
				.setParameter("userId",userId)
				.setParameter("reportId",reportId)
				.getSingleResult();
	}

}
