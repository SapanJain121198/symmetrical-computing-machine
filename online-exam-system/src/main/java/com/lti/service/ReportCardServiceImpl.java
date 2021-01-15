package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ReportCardDao;
import com.lti.dto.ReportCardDto;

@Service
public class ReportCardServiceImpl implements ReportCardService{
	
	@Autowired
	ReportCardDao reportCardDao;
    
	@Autowired
	private ExamServiceImpl examService;
	
	@Override
	public ReportCardDto generateReport(int userId) {
		return reportCardDao.generateReport(userId,examService.getReportId());
	}
	
}
