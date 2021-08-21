package com.thiago.hrpayroll.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CallNotPermittedException.class)
	public ResponseEntity<StandardError> elementNotFoundExceptionHandler(CallNotPermittedException e, HttpServletRequest request){
		
		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		
		error.setError("Circuit Breaker opened");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		error.setStatus(status.value());
		error.setTimestamp(Instant.now());
		
		return ResponseEntity.status(status).body(error);		
	}
	
}
