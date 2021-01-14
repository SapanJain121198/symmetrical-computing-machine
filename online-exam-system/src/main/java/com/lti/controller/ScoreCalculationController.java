package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.ScoreCalculationService;

@RestController
@CrossOrigin
public class ScoreCalculationController {
	
	@Autowired
	private ScoreCalculationService scoreCalculationService;
	
	@PostMapping("/submitresponse")
	public void UpdateScore(@RequestParam("questionid") int questionId, @RequestParam("optionChosen") int optionChosen) {
		
		scoreCalculationService.ScoreCalcuation(questionId, optionChosen);
		
	}

}
