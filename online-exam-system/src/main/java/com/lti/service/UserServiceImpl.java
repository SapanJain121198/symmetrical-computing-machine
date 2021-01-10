package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.lti.dao.AdminProjectDao;
import com.lti.dao.RegisteredUserDao;
import com.lti.dto.Password;
import com.lti.dto.SendMail;
import com.lti.entity.AdminProject;
import com.lti.entity.RegisteredUser;
import com.lti.exception.UserServiceException;

public class UserServiceImpl implements UserService {

	@Autowired
	private RegisteredUserDao registeredUserDao;
	
	@Autowired
	private AdminProjectDao adminProjectDao;

	@Override
	public int register(RegisteredUser registeredUser) {
		if (registeredUserDao.isUserRegistered(registeredUser.getEmail()))
			throw new UserServiceException("Student already registered");

		
		Password pwd = new Password();
		String password = pwd.makePassword();
		
		registeredUser.setPassword(password);
		
		RegisteredUser updatedUser = (RegisteredUser) registeredUserDao.save(registeredUser);

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

			int id = registeredUserDao.findByEmailAndPassword(email, password);

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
	
	@Override
	public String forgotPassword(String newPassword, String confirmPassword, String email) {
		
		try {
			RegisteredUser registeredUser=new RegisteredUser();
			if (!registeredUserDao.isUserRegistered(email))
				throw new UserServiceException("Customer not registered!");
			
			if(newPassword.equals(confirmPassword)) {
				registeredUser.setPassword(newPassword);
				registeredUserDao.changePassword(registeredUser);
				
				SendMail mail= new SendMail();
				
				mail.sendNotificationForPassword(registeredUser);
				
				}
			
		
			return "Password Changed Successfully";
			}
			catch(UserServiceException e) {
				throw new UserServiceException("Password not matching");
				
			}
		
	}
}
