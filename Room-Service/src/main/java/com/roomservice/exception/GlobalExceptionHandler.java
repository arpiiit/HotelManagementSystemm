package com.roomservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = RoomsNotAvailableException.class)
	public ResponseEntity<String> handleRoomsNotAvailableException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = RoomNotFoundWithIdException.class)
	public ResponseEntity<String> handleRoomNotFoundWithIdException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = DuplicateEntryException.class)
	public ResponseEntity<String> handleDuplicateEntryException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value = RoomNotFoundWithRoomNoException.class)
	public ResponseEntity<String> handleRoomNotFoundWithRoomNoException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
