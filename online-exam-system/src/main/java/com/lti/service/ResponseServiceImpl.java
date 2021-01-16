package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ResponseDao;

@Service
//@Transactional
public class ResponseServiceImpl implements ResponseService {
	
	
	@Autowired
	private ResponseDao responseDao;
	
	@Autowired
	private ExamServiceImpl examService;

	@Override
	public void saveResponse(int questionId, int optionChosen, int reportId) {
	   responseDao.saveResponse(questionId, reportId , optionChosen);
	}
	
}
