package com.ownerservice.exception;

public class DepartmentNotFoundWithId extends RuntimeException 
{
 public DepartmentNotFoundWithId(String msg)
 {
	 super(msg);
 }
}
