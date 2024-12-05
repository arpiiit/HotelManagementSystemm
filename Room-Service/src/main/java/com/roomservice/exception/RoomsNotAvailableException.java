package com.roomservice.exception;

public class RoomsNotAvailableException extends RuntimeException {
 
	public RoomsNotAvailableException(String msg)
	{
		super(msg);
	}
}
