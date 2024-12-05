package com.receptionistservice.exception;

public class InvalidMobileNumberException extends RuntimeException 
{
   public InvalidMobileNumberException(String msg)
   {
	   super(msg);
   }
}
