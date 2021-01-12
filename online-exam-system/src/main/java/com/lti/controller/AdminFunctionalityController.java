package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Question;
import com.lti.service.AdminFunctionalityService;

@RestController
@CrossOrigin
public class AdminFunctionalityController {

	@Autowired
	private AdminFunctionalityService adminFunctionalityService;

	
	// public void addQuestion(@RequestParam("subjectName")String subjectName, @RequestParam("questionDesc") String )
	@PostMapping("/addquestion")
	public void receiveQuestion(Question question) {

		adminFunctionalityService.addQuestion(question);
	}

}
