package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.dto.Password;
import com.lti.entity.RegisteredUser;

@Repository
public class RegisteredUserDao extends GenericDao {
	
	
	public RegisteredUser saveUser(RegisteredUser registeredUser) {
		String password = Password.makePassword();
		registeredUser.setPassword(password);
		RegisteredUser updatedRegisteredUser = entityManager.merge(registeredUser);
		return updatedRegisteredUser;
	}
	
	public RegisteredUser fetchUserById(int userId) {
		return (RegisteredUser)entityManager.createQuery("select r from RegisteredUser r where r.userId =:userId")
				.setParameter("userId",userId)
				.getSingleResult();
		
		//return updatedRegisteredUser;
	}
	
	public boolean isUserRegistered(String email)
	{
		
		//typecasted to long because count function return type is long
		return (Long)entityManager.createQuery("select count(u.userId) from RegisteredUser u where u.email =:email")
				.setParameter("email",email)
				.getSingleResult()==1? true : false;
		
		
	}
	
	public int findByEmailAndPassword(String email, String password)
	{
		return (Integer)
				entityManager.createQuery("select u.id from RegisteredUser u where u.email = :email and u.password = :password")     
				.setParameter("email", email).setParameter("password", password).getSingleResult();
	}
	

	
	public void changePassword(RegisteredUser registeredUser) {
		
		entityManager.merge(registeredUser);
		
	}
	
}
