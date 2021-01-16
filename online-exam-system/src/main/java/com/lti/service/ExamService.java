package com.lti.service;

import com.lti.dto.ExamQuestions;

public interface ExamService {
	
	
									
	public ExamQuestions takeExam(int userId, String subjectName);
}
