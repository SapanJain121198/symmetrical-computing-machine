package com.lti.service;

import java.util.List;

import com.lti.entity.RegisteredUser;

public interface SearchStudentService {
	
	public List<RegisteredUser> fetchStudents( int score,int testLevel,String testSubjectName,String city,String state);

}