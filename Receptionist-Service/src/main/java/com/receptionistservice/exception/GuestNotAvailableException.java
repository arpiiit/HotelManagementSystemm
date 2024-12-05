package com.receptionistservice.exception;

public class GuestNotAvailableException extends RuntimeException 
{
  public GuestNotAvailableException(String msg)
  {
	  super(msg);
  }
}
