package com.lti.dto;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
	
	
	public static String makePassword() {
		String password="";
		int length=10;
		for(int i=0;i<length-2;i++) {
			password=password + randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ");	
		}
		String randomDigit=randomCharacter("0123456789");
		password=insertAtRandom(password,randomDigit);
		
		String randomSymbol=randomCharacter("!@#$&*");
		password=insertAtRandom(password,randomSymbol);
		
		return password;
	}
	
	public static String randomCharacter(String alphabets) {
		int n=alphabets.length();
		int r=(int) (n*Math.random());
		return alphabets.substring(r,r+1);
	}
	
	public static String insertAtRandom(String str,String toInsert) {
		int n=str.length();
		int r=(int) ((n+1) * Math.random());
		return str.substring(0,r) + toInsert + str.substring(r);
		
	}
}