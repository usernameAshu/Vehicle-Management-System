package com.mohanty.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.mohanty.util.AppDateTime;

@ControllerAdvice
public class AppExceptionHandling {

	@Autowired
	AppErrorResponse errorResponse;
	
	@Autowired
	AppDateTime timestamp;

	/**
	 * Adding generic exception handling
	 */

	public ResponseEntity<AppErrorResponse> handleException(Exception exc) {
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimestamp(timestamp.getCurrentDate());

		return new ResponseEntity<AppErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Custom error response
	 */

	public ResponseEntity<AppErrorResponse> handleException(AppException exc) {

		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimestamp(timestamp.getCurrentDate());

		return new ResponseEntity<AppErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
