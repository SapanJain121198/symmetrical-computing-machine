package com.lti.service;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.NewExamDao;
import com.lti.dao.RegisteredUserDao;
import com.lti.dto.ExamQuestions;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;

@Service

public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private NewExamDao newExamDao;
	
	@Autowired
	private RegisteredUserDao registeredUserDao;
	
	//public int reportId;
	

	@Transactional
	@Override
	public ExamQuestions takeExam(int userId, String subjectName) {
		
		if(!newExamDao.hasClearedLevel(userId, subjectName, 1)) {
			
			TestReport testReport = new TestReport();
			testReport.setTestSubjectName(subjectName);
			testReport.setTestLevel(1);
			testReport.setRegisteredUser(registeredUserDao.fetchByKey(RegisteredUser.class, userId));
			testReport.setDateAndTime(LocalDateTime.now());
			return newExamDao.fetchExam(subjectName, testReport, 1);
		}
		
		else if(!newExamDao.hasClearedLevel(userId, subjectName, 2)) {
			
			TestReport testReport = new TestReport();
			testReport.setTestSubjectName(subjectName);
			testReport.setTestLevel(2);
			testReport.setRegisteredUser(registeredUserDao.fetchByKey(RegisteredUser.class, userId));
			testReport.setDateAndTime(LocalDateTime.now());
			return newExamDao.fetchExam(subjectName, testReport, 2);
		}
		
		TestReport testReport = new TestReport();
		testReport.setTestSubjectName(subjectName);
		testReport.setTestLevel(3);
		testReport.setRegisteredUser(registeredUserDao.fetchByKey(RegisteredUser.class, userId));
		testReport.setDateAndTime(LocalDateTime.now());
		return newExamDao.fetchExam(subjectName, testReport, 3);

	}
	
}

