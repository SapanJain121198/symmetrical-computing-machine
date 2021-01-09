package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.lti.dao.RegisteredUserDao;
import com.lti.entity.AdminProject;
import com.lti.entity.RegisteredUser;
import com.lti.exception.UserServiceException;

public class UserServiceImpl implements UserService {

	@Autowired
	private RegisteredUserDao registeredUserDao;
	
	@Autowired
	private AdminProjectDao adminProjectDao;

	public int register(RegisteredUser registeredUser) {
		if (registeredUserDao.isUserRegistered(registeredUser.getEmail()))
			throw new UserServiceException("Student already registered");

		RegisteredUser updatedUser = (RegisteredUser) registeredUserDao.save(registeredUser);

		// code to send email to the customer on successful registration will be here

		return updatedUser.getUserId();
	}

	public RegisteredUser Userlogin(String email, String password) {

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

	public AdminProject adminlogin(int id , String password) {

		try {

			if (!AdminProjectDao.isAdminRegistered(id))
				throw new UserServiceException("Admin not registered!");

			int adminId = AdminProjectDao.findByIdAndPassword(id, password);

			AdminProject adminProject = adminProjectDao.fetchByKey(AdminProject.class, adminId);

			return adminProject;

		}

		catch (EmptyResultDataAccessException e) {
			throw new UserServiceException("Incorrect email/password");
		}

	}
	
	
	
	public String forgotPassword(String newPassword, String confirmPassword, String email) {
		
		try {
			RegisteredUser registeredUser=new RegisteredUser();
			if (!registeredUserDao.isUserRegistered(email))
				throw new UserServiceException("Customer not registered!");
			
			if(newPassword.equals(confirmPassword)) {
				registeredUser.setPassword(newPassword);
				registeredUserDao.changePassword(registeredUser);
				}
			}
			catch(UserServiceException e) {
				throw new UserServiceException("Password not matching");
				
			}
		
		
	}
	
	
	
	
	

}
