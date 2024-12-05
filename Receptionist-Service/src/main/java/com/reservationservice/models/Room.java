package com.reservationservice.models;

public class Room {

	private int roomId;
	private int roomNo;
	private String roomType;
	private String roomDesc;
	private double roomPrice;
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
