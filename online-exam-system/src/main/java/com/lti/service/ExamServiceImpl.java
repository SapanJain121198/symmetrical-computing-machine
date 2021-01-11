package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.NewExamDao;
import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private NewExamDao newExamDao;
	
	@Override
	public List<Question> takeExam(RegisteredUser registeredUser , String subjectName) {
		
		if(!newExamDao.hasClearedLevel(registeredUser, subjectName, 1)) {
			
			TestReport testReport = new TestReport();
			testReport.setTestSubjectName(subjectName);
			
			
			
			
			return newExamDao.fetchExam(subjectName, 1);
		}
		
		else if(!newExamDao.hasClearedLevel(registeredUser, subjectName, 2)) {
			return newExamDao.fetchExam(subjectName, 2);
		}
		
		else if(!newExamDao.hasClearedLevel(registeredUser, subjectName, 3)) {
		return newExamDao.fetchExam(subjectName, 3);
		}
		
		
		
		// we have to right logic for a person clearing all levels
		
		
		else return null;
	}

	
}
