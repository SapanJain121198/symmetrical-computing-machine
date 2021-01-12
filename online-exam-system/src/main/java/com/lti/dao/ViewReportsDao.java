package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.TestReport;

@Repository
public class ViewReportsDao extends GenericDao{
	
	public List<TestReport> fetchAllReports(){
		return (List) entityManager.createQuery("SELECT t FROM TestReport t",TestReport.class).getResultList();
	}
	

}
