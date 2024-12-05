package com.receptionistservice.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuestDetails")
public class Guest 
{
	 @Transient
	    public static final String SEQUENCE_NAME = "guest_sequence";
	@Id
	private int guestId;
	@NotNull
	private String guestName;
	@NotNull
	private String guestMobile;
	@NotNull
	private String guestEmail;
	@NotNull
	private String guestGender;
	@NotNull
	private String guestAddress;
	@NotNull
	private String guestGovtId;
	
	public String getGuestGovtId() {
		return guestGovtId;
	}
	public void setGuestGovtId(String guestGovtId) {
		this.guestGovtId = guestGovtId;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestMobile() {
		return guestMobile;
	}
	public void setGuestMobile(String guestMobile) {
		this.guestMobile = guestMobile;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestGender() {
		return guestGender;
	}
	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	
	
}
