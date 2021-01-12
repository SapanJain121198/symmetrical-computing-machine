package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.SearchStudentDao;
import com.lti.entity.RegisteredUser;

public class SearchStudentServiceImpl implements SearchStudentService {
	
	@Autowired
	private SearchStudentDao searchStudent;

	@Override
	public List<RegisteredUser> fetchStudents(int score, int testLevel, String testSubjectName, String city,
			String state) {
		// TODO Auto-generated method stub
		return this.searchStudent.fetchStudents(score, testLevel, testSubjectName, city,
				  state);
	}
}
