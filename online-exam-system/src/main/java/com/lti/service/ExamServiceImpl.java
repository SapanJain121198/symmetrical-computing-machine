package com.lti.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.NewExamDao;
import com.lti.dao.RegisteredUserDao;
import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;

@Service

public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private NewExamDao newExamDao;
	
	@Autowired
	private RegisteredUserDao registeredUserDao;
	
	@Override
	public List<Question> takeExam(int userId, String subjectName) {
		
		if(!newExamDao.hasClearedLevel(registeredUserDao.fetchByKey(RegisteredUser.class, userId), subjectName, 1)) {
			
			TestReport testReport = new TestReport();
			testReport.setTestSubjectName(subjectName);
			testReport.setTestLevel(1);
			testReport.setRegisteredUser(registeredUserDao.fetchByKey(RegisteredUser.class, userId));
			testReport.setDateAndTime(LocalDateTime.now());
			
			return newExamDao.fetchExam(subjectName, 1);
		}
		
		else if(!newExamDao.hasClearedLevel(registeredUserDao.fetchByKey(RegisteredUser.class, userId), subjectName, 2)) {
			
			TestReport testReport = new TestReport();
			testReport.setTestSubjectName(subjectName);
			testReport.setTestLevel(2);
			testReport.setRegisteredUser(registeredUserDao.fetchByKey(RegisteredUser.class, userId));
			testReport.setDateAndTime(LocalDateTime.now());
			
			return newExamDao.fetchExam(subjectName, 1);
		}
		
//		else if(!newExamDao.hasClearedLevel(userId, subjectName, 1)) {
//			
//			TestReport testReport = new TestReport();
//			testReport.setTestSubjectName(subjectName);
//			testReport.setTestLevel(1);
//			testReport.setRegisteredUser(registeredUserDao.fetchUserById(userId));
//			testReport.setDateAndTime(LocalDateTime.now());
//			
//			return newExamDao.fetchExam(subjectName, 1);
//		}
		
		
		TestReport testReport = new TestReport();
		testReport.setTestSubjectName(subjectName);
		testReport.setTestLevel(1);
		testReport.setRegisteredUser(registeredUserDao.fetchByKey(RegisteredUser.class, userId));
		testReport.setDateAndTime(LocalDateTime.now());
		
		return newExamDao.fetchExam(subjectName, 1);
		
	}
	
}

