package com.lti.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Question;

@Repository
public class AdminFunctionalityDao extends GenericDao {
	
	
	/*@Transactional
	public void  addQuestionToDb(Question question )
	{ 
		entityManager.persist(question);
		
	}*/
}
