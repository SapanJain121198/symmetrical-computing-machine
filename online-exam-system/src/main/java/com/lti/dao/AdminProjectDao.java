package com.lti.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AdminProjectDao extends GenericDao {
	
	public boolean isAdminPresent(int id) {
		return (Long) entityManager.createQuery("select count(c) from AdminProject c where id= :id")
				.setParameter("id", id)
				.getSingleResult() == 1 ? true : false;
	}
	
	public int findByIdAndPassword(int id, String password) {
		return (Integer) entityManager
				.createQuery("select c.id from AdminProject c where c.id= :id and c.password= :password")
				.setParameter("id", id)
				.setParameter("password", password)
				.getSingleResult();
	}

}
