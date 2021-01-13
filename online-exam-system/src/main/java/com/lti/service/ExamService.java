package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;

public interface ExamService {
	
	
									
	public List<Question> takeExam(String subjectName);
}
