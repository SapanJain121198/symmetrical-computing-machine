package com.lti.dto;

import com.lti.dto.Status.StatusType;

public class Status {
	
	private StatusType status;
	private String message;
	
	public static enum StatusType
	{
		SUCCESS,FALED;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}



