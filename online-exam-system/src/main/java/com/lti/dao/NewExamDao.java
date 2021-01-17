package com.lti.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.lti.dto.ExamQuestions;
import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;
import com.lti.entity.TestReport;

@Repository
public class NewExamDao extends GenericDao {

	public ExamQuestions fetchExam(String subjectName,TestReport testReport, int testLevel) {
		
		List<Integer> questionId =  entityManager.createQuery("select q.questionId from Question q where q.subjectName =:sbj and q.testLevel= :lvl")
				.setParameter("sbj", subjectName)
				.setParameter("lvl", testLevel)
				.getResultList();
		
		
		Collections.shuffle(questionId);
		List<Integer> questionIdNew = new ArrayList<Integer>() ;
		for(int i = 0; i<5 ;i++) {
			
			
			questionIdNew.add(questionId.get(i));
		}
		
		List<Question> questionList = new ArrayList<Question>() ;
		
		for(int id : questionIdNew) {
		
			Question question = (Question) entityManager
			.createQuery("select q from Question q where q.subjectName =:sbj and q.testLevel= :lvl and q.questionId = :id")
		    .setParameter("id", id)
			.setParameter("sbj", subjectName)
			.setParameter("lvl", testLevel)
			.getSingleResult();
			
			questionList.add(question);
		}
		
		ExamQuestions examQuestions = new ExamQuestions();
		
		TestReport updatedTestReport = entityManager.merge(testReport);
		
		examQuestions.setQuestions(questionList);
		
		examQuestions.setReportId(updatedTestReport.getReportId());
		
		return examQuestions;
	}
	
	public boolean hasClearedLevel(int userId, String subjectName, int testLevel) {
		
		//select t from TestReport t join t.registeredUser r  where t.score>=20 and r.userId = :ru and t.testSubjectName = :sbj and t.testLevel = :lvl
		
		return (Integer)entityManager.createQuery("select t.score from TestReport t join t.registeredUser r  where t.score>=20 and r.userId = :ru and t.testSubjectName = :sbj and t.testLevel = :lvl")
				.setParameter("ru",userId)
				.setParameter("sbj", subjectName)
				.setParameter("lvl", testLevel)
				.getSingleResult() == 1 ? true : false;
	}
	
}
