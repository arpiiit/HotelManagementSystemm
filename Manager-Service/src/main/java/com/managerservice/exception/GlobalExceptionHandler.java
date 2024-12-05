package com.managerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = StaffNotFoundWithIdException.class)
	public ResponseEntity<String> handleStaffNotFoundWithIdException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = StaffNotAvailableException.class)
	public ResponseEntity<String> handleStaffNotAvailableException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = DuplicateEntryException.class)
	public ResponseEntity<String> handleDuplicateEntryException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = ManagerNotFoundException.class)
	public ResponseEntity<String> handleManagerNotFoundException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<String> handleInvalidCredentialsException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	
}
