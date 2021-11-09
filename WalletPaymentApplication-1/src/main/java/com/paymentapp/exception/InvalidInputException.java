package com.paymentapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvalidInputException extends Exception {
	public InvalidInputException(String msg) {
		super(msg);
	}

}