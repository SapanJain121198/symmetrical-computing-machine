package com.lti.service;

import com.lti.entity.AdminProject;
import com.lti.entity.RegisteredUser;
import java.util.*;

public interface UserService {
	
	public int register(RegisteredUser registeredUser);
	public  RegisteredUser userLogin(String email , String password);
	public AdminProject adminLogin(int id,String password );
    
}
