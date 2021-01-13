package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lti.entity.Question;
import com.lti.service.AdminFunctionalityService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminFunctionalityController {

	@Autowired
	private AdminFunctionalityService adminFunctionalityService;

	
	// public void addQuestion(@RequestParam("subjectName")String subjectName, @RequestParam("questionDesc") String )
	@PostMapping("/addquestion")
	public void receiveQuestion(@RequestBody Question question) {

		adminFunctionalityService.addQuestion(question);
	}
	
	@PostMapping("/upload")
	public void uploadFile(@RequestParam("file") MultipartFile file)
	{
		adminFunctionalityService.fileUpload(file);
		
	}

}
