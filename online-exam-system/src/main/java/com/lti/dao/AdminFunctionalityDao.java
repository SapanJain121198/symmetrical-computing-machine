package com.lti.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Question;

@Repository
public class AdminFunctionalityDao extends GenericDao {
	
	@Transactional
	public void removeQuestion(String subjectName, int testLevel)
	{
	
		entityManager.createQuery("delete from Question q where q.subjectName=:sbj and q.testLevel=:test")
		.setParameter("sbj", subjectName)
		.setParameter("test", testLevel).executeUpdate();
		
	}
}
