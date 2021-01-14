package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ResponseDao;
import com.lti.entity.Question;
import com.lti.entity.TestReport;

@Service
//@Transactional
public class ResponseServiceImpl implements ResponseService {
	
	@Autowired
	private ResponseDao responseDao;

	@Override
	public void saveResponse(int questionId, int reportId, int optionChosen) {
	   responseDao.saveResponse(questionId, reportId, optionChosen);
	}
	
	
}
