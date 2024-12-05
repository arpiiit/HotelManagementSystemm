package com.managerservice.exception;

public class InvalidEmailAddressException extends RuntimeException 
{
 public InvalidEmailAddressException(String msg)
 {
	 super(msg);
 }
}
