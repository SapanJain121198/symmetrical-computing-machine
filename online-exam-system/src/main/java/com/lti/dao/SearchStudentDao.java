package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.RegisteredUser;

@Repository
public class SearchStudentDao extends GenericDao {
	
	public List<RegisteredUser> fetchStudents(int score, int testLevel,String testSubjectName,String city,String state){
		return entityManager
				.createQuery("select r from RegisteredUser  r innerjoin r.TestReport  t where t.score=:score and t. testLevel=:testLevel and t.testSubjectName=testSubjectName and r.city=:city and r.state=:state")
				.setParameter("score", score)
				.setParameter("testLevel",testLevel )
				.setParameter("testSubjectName",testSubjectName )
				.setParameter("city",city )
				.setParameter("state",state)
				.getResultList();
		
	}

}
