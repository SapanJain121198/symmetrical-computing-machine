package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.ResponseService;

@RestController
@CrossOrigin
public class ResponseController {
	
	@Autowired
	private ResponseService responseService;
	
	@GetMapping("/response")
	public void saveChosenOption(@RequestParam("questionId") int questionId, @RequestParam("optionChosen") int optionChosen) {
		
		responseService.saveResponse(questionId, optionChosen);
		
	}

}
