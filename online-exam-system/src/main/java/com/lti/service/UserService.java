package com.lti.service;

import com.lti.entity.AdminProject;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;

import java.util.*;

public interface UserService {
	
	public int register(RegisteredUser registeredUser);
	public  RegisteredUser userLogin(String email , String password);
	public AdminProject adminLogin(int id,String password );
	
	public List<TestReport> fetchUserReport(int userId);
	
	public int MaxLevelCleared(int userId, String subjectName);
	
	public void resetPassword(String email);
}
