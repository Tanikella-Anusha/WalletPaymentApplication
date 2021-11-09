package com.paymentapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
public class MobileNumberNotRegistered extends Exception{
	
	public MobileNumberNotRegistered(String msg) {
		super(msg);
	}

}

