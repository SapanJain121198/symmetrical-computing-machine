package com.lti.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ExamQuestions;
import com.lti.service.ExamService;

@RestController
@CrossOrigin
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@GetMapping("/startexam")
	public @ResponseBody ExamQuestions startExam(@RequestParam("userId") int userId, @RequestParam("subjectName") String subjectName){
		
		return examService.takeExam(userId, subjectName);
	}
	
}
