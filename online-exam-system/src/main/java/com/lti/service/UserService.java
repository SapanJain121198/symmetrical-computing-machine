package com.lti.service;

import com.lti.entity.RegisteredUser;

public interface UserService {
	
	public int register(RegisteredUser registeredUser);
	public  RegisteredUser login(String email , String password);
	
    
}
