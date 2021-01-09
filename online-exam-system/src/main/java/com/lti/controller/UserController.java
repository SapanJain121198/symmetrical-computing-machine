package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RegisterStatus;
import com.lti.dto.Status.StatusType;
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
}
