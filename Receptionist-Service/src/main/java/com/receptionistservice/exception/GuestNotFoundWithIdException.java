package com.receptionistservice.exception;

public class GuestNotFoundWithIdException extends RuntimeException {
	
	public GuestNotFoundWithIdException(String msg)
	{
		super(msg);
	}

}
