package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminFunctionalityDao;
import com.lti.entity.Question;

@Service
public class AdminFunctionalityServiceImpl implements AdminFunctionalityService {

	@Autowired
	private AdminFunctionalityDao adminFunctionalityDao;
	
	@Override
	@Transactional
	public void addQuestion(Question question) {
		
		 adminFunctionalityDao.save(question);
		
		
	}
	
	
}
