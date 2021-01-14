package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ReportCardDto;
import com.lti.entity.Question;
import com.lti.entity.RegisteredUser;
import com.lti.service.ReportCardService;


@RestController
@CrossOrigin
public class ReportCardController {
	
	@Autowired
	private ReportCardService reportCardService;
	
	@PostMapping("/generatereport")
	public @ResponseBody ReportCardDto generateReport(@RequestParam("userId") int userId) {
		return reportCardService.generateReport(userId);
		
	}
	

}
