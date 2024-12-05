package com.roomservice.exception;

public class RoomNotFoundWithIdException extends RuntimeException 
{
  public RoomNotFoundWithIdException(String msg)
  {
	  super(msg);
  }
}
