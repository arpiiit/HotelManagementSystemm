package com.receptionistservice.exception;

public class ReceptionistNotFoundException extends RuntimeException 
{
 public ReceptionistNotFoundException(String msg)
 {
	 super(msg);
 }
}
