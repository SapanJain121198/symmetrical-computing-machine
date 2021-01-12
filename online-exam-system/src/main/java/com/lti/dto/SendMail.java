package com.lti.dto;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.lti.entity.RegisteredUser;

public class SendMail {
	
	public void sendNotificationEmail(RegisteredUser registeredUser) {
		
		// code to send email to the customer on successful registration will be here

		
		 // Recipient's email ID needs to be mentioned.
	      String to = registeredUser.getEmail();    // this needs to be created

	      // Sender's email ID needs to be mentioned
	      String from = "sapanjain121198@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	     // Properties properties = System.getProperties();

	      // Setup mail server
	      //properties.setProperty("mail.smtp.host", host);
	      
	      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	      // Get a Properties object
	         Properties props = System.getProperties();
	         props.setProperty("mail.smtp.host", "smtp.gmail.com");
	         props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	         props.setProperty("mail.smtp.socketFactory.fallback", "false");
	         props.setProperty("mail.smtp.port", "465");
	         props.setProperty("mail.smtp.socketFactory.port", "587");
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.debug", "true");
	         props.put("mail.store.protocol", "pop3");
	         props.put("mail.transport.protocol", "smtp");
	      
	      
	      

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(props);
	         
	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	       //  message.addRecipient(type, address);
	         
	         
	         // Set Subject: header field
	         message.setSubject("Registration Successful in Online Exam System!!!");

	         // Now set the actual message
	         message.setText("Your registered email is "+ registeredUser.getEmail()+"/n Password is "+ registeredUser.getPassword());

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } 
	      catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
	
	
	
	
public void sendNotificationForPassword(RegisteredUser registeredUser) {
		
		// code to send email to the customer on successful registration will be here

		
		 // Recipient's email ID needs to be mentioned.
	      String to = registeredUser.getEmail();    // this needs to be created

	      // Sender's email ID needs to be mentioned
	      String from = "abcd@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	       //  message.addRecipient(type, address);
	         
	         
	         // Set Subject: header field
	         message.setSubject("Password Changed Successfully!!!");

	         // Now set the actual message
	         message.setText("Your New password is  "+ registeredUser.getPassword());

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } 
	      catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}

}
