package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ReportCardDto;
import com.lti.service.ReportCardService;


@RestController
@CrossOrigin
public class ReportCardController {
	
	@Autowired
	private ReportCardService reportCardService;
	
	@GetMapping("/generatereport")
	public @ResponseBody ReportCardDto generateReport(@RequestParam("userId") int userId) {
		return reportCardService.generateReport(userId);
		
	}
	

}
