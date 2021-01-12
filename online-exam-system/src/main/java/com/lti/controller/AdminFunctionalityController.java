package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Question;
import com.lti.service.AdminFunctionalityService;

@RestController
@CrossOrigin
public class AdminFunctionalityController {

	@Autowired
	private AdminFunctionalityService adminFunctionalityService;

	
	// public void addQuestion(@RequestParam("subjectName")String subjectName, @RequestParam("questionDesc") String )
	@GetMapping("/addquestion")
	public void receiveQuestion(@RequestBody Question question) {

		adminFunctionalityService.addQuestion(question);
	}

}
