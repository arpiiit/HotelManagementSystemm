package com.roomservice.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "room")
public class Room {
	 @Transient
	    public static final String SEQUENCE_NAME = "room_sequence";
	@Id
	private int roomId;
	@NotNull
	private int roomNo;
	@NotNull
	private String roomType;
	@NotNull
	private String roomDesc;
	@NotNull
	private double roomPrice;
	@NotNull
	private boolean roomAvail;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public boolean isRoomAvail() {
		return roomAvail;
	}

	public void setRoomAvail(boolean roomAvail) {
		this.roomAvail = roomAvail;
	}

}
