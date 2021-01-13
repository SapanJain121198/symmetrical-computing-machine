package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;

@Repository
public class NewExamDao extends GenericDao {

	public List<Question> fetchExam(String subjectName, int testLevel) {
		
		return entityManager
				.createQuery("select q from Question q where q.subjectName =:sbj and q.testLevel= :lvl")
				.setParameter("sbj", subjectName)
				.setParameter("lvl", testLevel)
				.getResultList();

	}
	
	public boolean hasClearedLevel(int userId, String subjectName, int testLevel) {
		
		
		return (Integer)entityManager.createQuery("select t from TestReport t join t.registeredUser r  where t.score>=20 and r.userId = :ru and t.testSubjectName = :sbj and t.testLevel = :lvl")
				.setParameter("ru",userId)
				.setParameter("sbj", subjectName)
				.setParameter("lvl", testLevel)
				.getSingleResult() == 1 ? true : false;
	}
	
}
