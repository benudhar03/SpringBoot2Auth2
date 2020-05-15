package com.baseoauth.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NotFoundCustomException.class) 
	public final ResponseEntity<CustomExceptionModel> handleCustomException(Exception ex, WebRequest request) throws Exception { 
		CustomExceptionModel cex = new CustomExceptionModel(new Date(), ex.getMessage(), "Exception Occured");
		return new ResponseEntity<CustomExceptionModel>(cex, HttpStatus.NOT_FOUND); 
	}	  
}
