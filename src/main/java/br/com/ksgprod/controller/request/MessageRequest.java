package br.com.ksgprod.controller.request;

import java.io.Serializable;

public class MessageRequest implements Serializable {

	private static final long serialVersionUID = 1130986476381808679L;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
