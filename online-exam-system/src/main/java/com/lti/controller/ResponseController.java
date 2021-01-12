package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Question;
import com.lti.entity.TestReport;
import com.lti.service.ResponseService;

@RestController
@CrossOrigin
public class ResponseController {
	
	@Autowired
	private ResponseService responseService;
	
	@GetMapping("/response")
	public void saveChosenOption(@RequestBody Question question, @RequestBody TestReport testReport, @RequestParam("chosenoption") int chosenOption) {
		
		responseService.saveResponse(question, testReport, chosenOption);
		
	}

}
