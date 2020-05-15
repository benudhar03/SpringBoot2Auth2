package com.baseoauth.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomExceptionModel {

	private Date timeStamp;
	private String message;
	private String details;
	
	
}
