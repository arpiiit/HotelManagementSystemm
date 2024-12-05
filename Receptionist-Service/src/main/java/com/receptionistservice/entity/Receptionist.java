package com.receptionistservice.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ReceptionistInformation")
public class Receptionist {
	
	@Transient
    public static final String SEQUENCE_NAME = "receptionist_sequence";
	@Id
	private int receptionistId;
	@NotNull
	private String receptionistName;
	@NotNull
	private String receptionistMobile;
	@NotNull
	private String receptionistEmail;
	@NotNull
	private String userName;
	@NotNull
	private String password;

	public int getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(int receptionistId) {
		this.receptionistId = receptionistId;
	}

	public String getReceptionistName() {
		return receptionistName;
	}

	public void setReceptionistName(String receptionistName) {
		this.receptionistName = receptionistName;
	}

	public String getReceptionistMobile() {
		return receptionistMobile;
	}

	public void setReceptionistMobile(String receptionistMobile) {
		this.receptionistMobile = receptionistMobile;
	}

	public String getReceptionistEmail() {
		return receptionistEmail;
	}

	public void setReceptionistEmail(String receptionistEmail) {
		this.receptionistEmail = receptionistEmail;
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
