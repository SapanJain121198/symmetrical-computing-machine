package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ReportCardDao;
import com.lti.dto.ReportCardDto;

@Service
public class ReportCardServiceImpl implements ReportCardService{
	
	@Autowired
	ReportCardDao reportCardDao;
    
	@Override
	public ReportCardDto generateReport(int userId, int reportId) {
		return reportCardDao.generateReport(userId, reportId);
	}
	
}
