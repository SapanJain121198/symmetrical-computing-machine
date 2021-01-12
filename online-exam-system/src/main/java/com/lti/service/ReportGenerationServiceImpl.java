package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lti.dao.ViewReportsDao;
import com.lti.entity.TestReport;

@Service
@Transactional
public class ReportGenerationServiceImpl implements ReportGenerationService{
	
	@Autowired
	private ViewReportsDao viewRepoDao;
	
	
	
	public List<TestReport> fetchAllReportsList(){
		
		return viewRepoDao.fetchAllReports();
	}
	
	
	

}
