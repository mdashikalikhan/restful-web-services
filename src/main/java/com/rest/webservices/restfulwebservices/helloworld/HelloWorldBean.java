package com.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

	private String message;
	
	private String text;

	public HelloWorldBean(String message) {
		this.message = message;
		this.text = "Initialize";
	}

	
	
	public String getMessage() {
		return message;
	}

	

	public String getText() {
		return text;
	}



	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	
}
