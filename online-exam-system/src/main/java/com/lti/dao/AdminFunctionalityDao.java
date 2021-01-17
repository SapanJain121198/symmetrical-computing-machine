package com.lti.dao;

import java.util.List;

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
	
	@Transactional
	public List<Question> fetchQuestions(){//String subjectName, int testLevel) {
		
		return entityManager.createQuery("select q from Question q").getResultList();
				///.createQuery("select q from Question q where q.subjectName =:sbj and q.testLevel= :lvl")
				//.setParameter("sbj", subjectName)
			//	.setParameter("lvl", testLevel)
				//.getResultList();
} 
	public Question getQuestionById( int questionId)
	{
		return (Question) entityManager.createQuery("select q from Question q where q.questionId = :qId")
				.setParameter("qId", questionId).getSingleResult();
	}
	
	@Transactional
	public void updateQuestion( int questionId , Question question)
	{
		 entityManager.createQuery("update Question q set q.subjectName=:s , q.questionDesc=:qd , q.option1=:o1 ,q.option2=:o2, q.option3=:o3 ,q.option4=:o4 , q.correctAnswer=:c , q.testLevel=:tl where q.questionId = :qId ")
		.setParameter("qId", questionId)
		.setParameter("s", question.getSubjectName())
		.setParameter("qd", question.getQuestionDesc())
		.setParameter("o1", question.getOption1())
		.setParameter("o2", question.getOption2())
		.setParameter("o3", question.getOption3())
		.setParameter("o4", question.getOption4())
		.setParameter("c", question.getCorrectAnswer())
		.setParameter("tl", question.getTestLevel()).executeUpdate();
		
		
		
	}
}
