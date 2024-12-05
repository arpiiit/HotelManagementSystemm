package com.receptionistservice.exception;

public class ReservationNotFoundWithIdException extends RuntimeException 
{
 public ReservationNotFoundWithIdException(String msg)
 {
	 super(msg);
 }
}
