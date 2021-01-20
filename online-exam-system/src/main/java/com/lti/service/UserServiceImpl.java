package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminProjectDao;
import com.lti.dao.RegisteredUserDao;
import com.lti.dto.SendMail;
import com.lti.entity.AdminProject;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;
import com.lti.exception.UserServiceException;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private RegisteredUserDao registeredUserDao;
	
	@Autowired
	private AdminProjectDao adminProjectDao;

	@Override
	@Transactional
	public int register(RegisteredUser registeredUser) {
		if (registeredUserDao.isUserRegistered(registeredUser.getEmail()))
			throw new UserServiceException("Student already registered");


		RegisteredUser updatedUser = registeredUserDao.saveUser(registeredUser);
		
		
		// code to send email to the customer on successful registration will be here

		SendMail email= new SendMail();
	
		email.sendNotificationEmail(registeredUser);
		
		
		return updatedUser.getUserId();
	}

	@Override
	public RegisteredUser userLogin(String email, String password) {
		try {

			if (!registeredUserDao.isUserRegistered(email))
				throw new UserServiceException("Customer not registered!");

			int id = 0;
			try {
				id = registeredUserDao.findByEmailAndPassword(email, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RegisteredUser registeredUser = registeredUserDao.fetchByKey(RegisteredUser.class, id);

			return registeredUser;

		}

		catch (EmptyResultDataAccessException e) {
			throw new UserServiceException("Incorrect email/password");
		}
	}

	@Override
	public AdminProject adminLogin(int id, String password) {
		try {

			if (!adminProjectDao.isAdminPresent(id))
				throw new UserServiceException("Admin not registered!");

			int adminId = adminProjectDao.findByIdAndPassword(id, password);

			AdminProject adminProject = adminProjectDao.fetchByKey(AdminProject.class, adminId);

			return adminProject;

		}

		catch (EmptyResultDataAccessException e) {
			throw new UserServiceException("Incorrect email/password");
		}
	}
	
	
	public List<TestReport> fetchUserReport(int userId){
		
		return registeredUserDao.fetchUserReport(userId);
		
	}
	
	public int MaxLevelCleared(int userId, String subjectName) {
		
		return registeredUserDao.MaxLevelCleared(userId, subjectName);
		
	}
	
	@Transactional
	public void resetPassword(String email) {
		if (registeredUserDao.isUserRegistered(email)) {
			SendMail reset= new SendMail();
			registeredUserDao.fetchUserByEmailId(email);
			reset.sendNotificationForPassword(registeredUserDao.fetchUserByEmailId(email));
		}
		
		else
			throw new UserServiceException("Please enter registered email id");
		
	
	}
	
	
}
