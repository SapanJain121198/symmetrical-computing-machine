package com.lti.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLogin;
import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.RegisterStatus;
import com.lti.dto.Status.StatusType;
import com.lti.entity.AdminProject;
import com.lti.entity.RegisteredUser;
import com.lti.exception.UserServiceException;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public @ResponseBody RegisterStatus register(@RequestBody RegisteredUser registeredUser) {
			

		int id = userService.register(registeredUser);
		
		try {
		RegisterStatus status = new RegisterStatus();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Registration successful!");
		status.setRegisteredUserId(id);
		
		return status;
		}
		
		catch(UserServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	@PostMapping("/userlogin")
	public LoginStatus userLogin(@RequestBody Login login)
	{
		try
		{
			RegisteredUser registeredUser= userService.userLogin(login.getEmail(),login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("login successful");
			status.setUserId(registeredUser.getUserId());
			status.setFullName(registeredUser.getFullName());
			return status;
		}
		catch(UserServiceException e )
		{
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FALED);
			status.setMessage(e.getMessage());
			
	         return status;
		}
		
	}
	
	@PostMapping(path = "/adminlogin")
	public @ResponseBody LoginStatus adminLogin(@RequestBody AdminLogin login) {

		try {
			AdminProject admin= userService.adminLogin(login.getId(), login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setMessage("Login Success");
			status.setStatus(StatusType.SUCCESS);
			status.setUserId(admin.getId());
	        status.setFullName(admin.getPassword());
			return status;
		} catch(UserServiceException e ){
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FALED);
			status.setMessage(e.getMessage());
			
	         return status;
		}
	}
	
	@RequestMapping(path="/changepassword")
	public @ResponseBody void changePassword(@RequestParam("newpassword") String newPassword,@RequestParam("confirmpassword") String confirmPassword,@RequestParam("email") String email){
		
		userService.forgotPassword(newPassword, confirmPassword, email);
			
		}
	}

