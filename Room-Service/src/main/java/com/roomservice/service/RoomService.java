package com.roomservice.service;

import java.util.List;

import com.roomservice.entity.Room;
import com.roomservice.entity.RoomList;

public interface RoomService {
	Room addRoom(Room room);

	Room updateRoom(Room room);

	String deleteRoom(int id);

	List<Room> getRoomsAvail();
	
	List<Room> getAllRooms();
	
	Room findByRoomId(int id);
	
	List<Room> findByRoomType(String roomType, String roomDesc);
	
	Room getByRoomNo(int number);
	
	Room checkOut(int roomNo);
}
