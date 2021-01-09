package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Question")
public class Question {
	
	@Id
	@GeneratedValue
	@Column(name="QUESTIONID")
	private int questionId;
	
	@Column(name="SUBJECTNAME")
	private String subjectName;
	
	@Column(name="QUESTIONDESC")
	private String questionDesc;
	
	@Column(name="OPTION1")
	private String option1;
	
	@Column(name="OPTION2")
	private String option2;
	
	@Column(name="OPTION3")
	private String option3;
	
	@Column(name="OPTION4")
	private String option4;
	
	@Column(name="CORRECTANSWER")
	private int correctAnswer;
	
	@Column(name="TESTLEVEL")
	private int testLevel;
	
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getTestLevel() {
		return testLevel;
	}

	public void setTestLevel(int testLevel) {
		this.testLevel = testLevel;
	}
	
	

}
