package com.lti.service;

import org.springframework.web.multipart.MultipartFile;

import com.lti.entity.Question;

public interface AdminFunctionalityService {

	public void addQuestion(Question question);
	
	public void fileUpload(MultipartFile file);
	
	public void removeQuestion(String subjectName, int testLevel);
}
