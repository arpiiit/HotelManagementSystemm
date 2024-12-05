package com.receptionistservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(value = GuestNotFoundWithIdException.class)
	public ResponseEntity<String> handleGuestNotFoundWithIdException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = GuestNotAvailableException.class)
	public ResponseEntity<String> handleGuestNotAvailableException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = InvalidMobileNumberException.class)
	public ResponseEntity<String> handleInvalidMobileNumberException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = InvalidEmailAddressException.class)
	public ResponseEntity<String> handleInvalidEmailAddressException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ReservationNotFoundWithIdException.class)
	public ResponseEntity<String> handleReservationNotFoundWithIdException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = InvalidAdharNumberException.class)
	public ResponseEntity<String> handleInvalidAdharNumberException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = RoomNotFoundWithRoomNoException.class)
	public ResponseEntity<String> handleRoomNotFoundWithRoomNoException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = ReceptionistNotFoundException.class)
	public ResponseEntity<String> handleReceptionistNotFoundException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<String> handleInvalidCredentialsException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	
	


}
