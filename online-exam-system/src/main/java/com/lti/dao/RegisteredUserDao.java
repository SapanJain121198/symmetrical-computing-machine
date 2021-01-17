package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.dto.Password;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;

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
	}
	
	public RegisteredUser fetchUserByEmailId(String email) {
		return (RegisteredUser)entityManager.createQuery("select r from RegisteredUser r where r.email =:em")
				.setParameter("em",email)
				.getSingleResult();
	}
	
	public boolean isUserRegistered(String email)
	{
		
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
	
	
	public List<TestReport> fetchUserReport(int userId) {
		
		return (List<TestReport>) entityManager.createQuery("select t from TestReport t join t.registeredUser r where r.userId =:userId")
				.setParameter("userId",userId)
				.getResultList();
		
	}	
	
	public int MaxLevelCleared(int userId, String subjectName) {
		
		return (Integer) entityManager.createQuery("select max(t.testLevel) from TestReport t join t.registeredUser r where r.userId =:userId and t.testSubjectName = :subj and t.score >= 5")
				.setParameter("userId",userId)
				.setParameter("subj", subjectName)
				.getSingleResult();
		
	}
}
