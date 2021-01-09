package com.lti.dao;

import org.springframework.stereotype.Repository;

@Repository
public class RegisteredUserDao extends GenericDao {
	
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
	
	

}
