package com.lti.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lti.entity.Question;

public interface AdminFunctionalityService {

	public void addQuestion(Question question);
	
	public void fileUpload(MultipartFile file);
	
	public void removeQuestion(String subjectName, int testLevel);
	
public List<Question> fetchQuestions();//String subjectName, int testLevel);
	
	public Question getQuestionById( int questionId);
	
	public void updateQuestion(  int questionId ,  Question question);
}
