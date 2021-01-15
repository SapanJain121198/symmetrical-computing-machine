package com.lti.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lti.dao.AdminFunctionalityDao;
import com.lti.entity.Question;


@Service
public class AdminFunctionalityServiceImpl implements AdminFunctionalityService {

	@Autowired
	private AdminFunctionalityDao adminFunctionalityDao;
	
	@Override
	@Transactional
	public void addQuestion(Question question) {
		
		 adminFunctionalityDao.save(question);
		
		
	}
	
    @Transactional
	public void fileUpload(MultipartFile file)
	{
	  /*String docname = file.getOriginalFilename();
	  
	  try
	  {
		  Question doc = new Question(docname, file.getBytes(),file.getContentType());
		  adminFunctionalityDao.save(doc);
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();  
	  }*/
		
	}
    
    
    @Override
	public void removeQuestion(String subjectName, int testLevel) {
		
		adminFunctionalityDao.removeQuestion(subjectName, testLevel);
		
	}
	
	
}
