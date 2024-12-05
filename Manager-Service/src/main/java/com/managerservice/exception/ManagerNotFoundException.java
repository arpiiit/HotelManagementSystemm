package com.managerservice.exception;

public class ManagerNotFoundException extends RuntimeException{

	public ManagerNotFoundException(String msg)
	{
		super(msg);
	}
}
