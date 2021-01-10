package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.NewExamDao;
import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;

public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private NewExamDao newExamDao;
	
	@Override
	public List<Question> takeExam(RegisteredUser registeredUser , String subjectName) {
		
		if(!newExamDao.hasClearedLevel(registeredUser, subjectName, 1)) {
			return newExamDao.fetchExam(subjectName, 1);
		}
		
		else if(!newExamDao.hasClearedLevel(registeredUser, subjectName, 2)) {
			return newExamDao.fetchExam(subjectName, 2);
		}
		
		else if(!newExamDao.hasClearedLevel(registeredUser, subjectName, 3)) {
		return newExamDao.fetchExam(subjectName, 3);
		}
		
		// we have to write logic for a person clearing all the levels
		else return null;
	}

	
}
