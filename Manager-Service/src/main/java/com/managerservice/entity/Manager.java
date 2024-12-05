package com.managerservice.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="ManagerDetails")
public class Manager 
{
	 @Transient
	    public static final String SEQUENCE_NAME = "manager_sequence";
    @Id
	private int managerId;
    @Field("name")
    @NotNull(message="Name is required")
	private String managerName;
    @NotNull(message="Email is required")
	private String managerEmail;
    @NotNull(message="Mobile Number is required")
	private String managerPhone;
    @NotNull(message="user name is required")
	private String userName;
    @NotNull(message="password is required")
	private String password;
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
