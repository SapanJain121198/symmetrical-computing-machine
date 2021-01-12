package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.TestReport;
import com.lti.service.ReportGenerationService;

@RestController
@CrossOrigin
public class ReportGenerationController {

	@Autowired
	private ReportGenerationService responseService;
	
	@GetMapping("/viewReports")
	public List<TestReport> fetchTestReport()  {
		List<TestReport> testReports=new ArrayList<TestReport>();
		testReports=responseService.fetchAllReportsList();
		return testReports;
		}
}
