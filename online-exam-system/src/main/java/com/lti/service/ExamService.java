package com.lti.service;

import java.util.List;

import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;

public interface ExamService {

	public List<Question> takeExam(RegisteredUser registeredUser, String subjectName);
}
