package com.lti.dto;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.RegisteredUserDao;
import com.lti.entity.RegisteredUser;

public class SendMail {
	
	@Autowired
	RegisteredUserDao registeredUserDao;
	
	public void sendNotificationEmail(RegisteredUser registeredUser){
		final String recepient = registeredUser.getEmail();
		 final String sender = "onlineexamsystem@outlook.com";  // like yourname@outlook.com
		    final String password = "online1234";   // password here

		    Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", "smtp-mail.outlook.com");
		    props.put("mail.smtp.port", "587");

		    Session session = Session.getInstance(props,
		      new javax.mail.Authenticator() {
		        @Override
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(sender, password);
		        }
		    });
		
	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(sender));

	         // Set To: header field of the header.
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));

	       //  message.addRecipient(type, address);
	         
	         
	         // Set Subject: header field
	         message.setSubject("Registration Successful in Online Exam System!!!");

	         // Now set the actual message
	       
	         message.setText("Your registered email is "+ registeredUser.getEmail()+"  Password is "+ registeredUser.getPassword());

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } 
	      catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
	
	
	
	
public void sendNotificationForPassword(RegisteredUser registeredUser) {
	
	//RegisteredUserDao registeredUserDao = new RegisteredUserDao();
		
	final String recepient = registeredUser.getEmail();
	 final String sender = "onlineexamsystem@outlook.com";  // like yourname@outlook.com
	    final String password = "online1234";   // password here

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp-mail.outlook.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(sender, password);
	        }
	    });
       
    try {
       // Create a default MimeMessage object.
       MimeMessage message = new MimeMessage(session);

       // Set From: header field of the header.
       message.setFrom(new InternetAddress(sender));

       // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));

     //  message.addRecipient(type, address);
	         
	         
	         // Set Subject: header field
	         message.setSubject("Your online exam system login credentials!!!");

	         // Now set the actual message  
	         String pwd = registeredUser.getPassword();
	         message.setText("Your registered email is "+ recepient +"  Password is "+ pwd);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } 
	      catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}

}
