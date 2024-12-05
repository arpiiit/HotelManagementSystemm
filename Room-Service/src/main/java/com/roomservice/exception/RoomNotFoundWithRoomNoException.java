package com.roomservice.exception;

public class RoomNotFoundWithRoomNoException extends RuntimeException {

	public RoomNotFoundWithRoomNoException(String msg)
	{
		super(msg);
	}
}
