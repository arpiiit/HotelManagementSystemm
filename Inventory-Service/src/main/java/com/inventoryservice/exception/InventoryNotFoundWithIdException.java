package com.inventoryservice.exception;

public class InventoryNotFoundWithIdException extends RuntimeException {
	
	public InventoryNotFoundWithIdException(String msg)
	{
		super(msg);
	}

}
