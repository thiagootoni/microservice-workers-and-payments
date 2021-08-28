package com.thiago.hruser.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thiago.hruser.services.exceptions.ElementNotFoundException;


@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ElementNotFoundException.class)
	public ResponseEntity<StandardError> elementNotFoundExceptionHandler(ElementNotFoundException e, HttpServletRequest request){
		
		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		error.setError("Element not found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatus(status.value());
		error.setTimestamp(Instant.now());
		
		return ResponseEntity.status(status).body(error);		
	}
	
}
