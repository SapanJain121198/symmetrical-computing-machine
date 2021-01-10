package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;

@Repository
public class NewExamDao extends GenericDao {

	public List<Question> fetchExam(String subjectName, int testLevel) {
		
	
		return entityManager
				.createQuery("select q from Question q where q.subjectName =:sbj and q.testLevel= :lvl")
				.setParameter("sbj", subjectName)
				.setParameter("lvl", testLevel)
				.getResultList();

	}
	
	public boolean hasClearedLevel(RegisteredUser registeredUser, String subjectName, int testLevel) {
		
		int id = registeredUser.getUserId();
		
		return (Integer)entityManager.createQuery("select r.score from Report r where r.score>=20 and r.registeredUser = :ru and r.testSubjectName = :sbj and r.testLevel = :lvl")
				.setParameter(":ru",registeredUser)
				.setParameter("sbj", subjectName)
				.setParameter("lvl", testLevel)
				.getSingleResult() == 1 ? true : false;
	}
	
}
