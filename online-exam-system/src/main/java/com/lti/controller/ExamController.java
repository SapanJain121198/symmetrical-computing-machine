package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;
import com.lti.service.ExamService;

@RestController
@CrossOrigin
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@GetMapping("/startexam")
	public @ResponseBody List<Question> startExam(@RequestParam("subjectName") String subjectName){
		
//		if(!newExamDao.hasClearedLevel(registeredUser, subjectName, 3)) {
//			return newExamDao.fetchExam(subjectName, 3);
//			}
		
		//public @ResponseBody List<Question> startExam(@RequestBody RegisteredUser registeredUser, @RequestParam("subjectName") String subjectName)

		return examService.takeExam(subjectName);
									//registeredUser,
	}
	
}
