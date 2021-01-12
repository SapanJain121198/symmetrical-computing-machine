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
import com.lti.service.SearchStudentService;

@RestController
@CrossOrigin
public class SearchStudentController {
	
	@Autowired
	private SearchStudentService searchStudentService;
	
	@GetMapping("/searchStudent")
	public @ResponseBody List<RegisteredUser> fetchStudents(@RequestParam("score") int score,@RequestParam("testLevel") int testLevel, @RequestParam("subjectName") String testSubjectName,@RequestParam("city") String city,
			@RequestParam("state") String state){
		return searchStudentService.fetchStudents(score, testLevel, testSubjectName, city, state);
		
	}
	

}
