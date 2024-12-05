package com.roomservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomservice.entity.Room;
import com.roomservice.entity.RoomList;
import com.roomservice.exception.DuplicateEntryException;
import com.roomservice.exception.RoomNotFoundWithIdException;
import com.roomservice.exception.RoomNotFoundWithRoomNoException;
import com.roomservice.exception.RoomsNotAvailableException;
import com.roomservice.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private SequenceGeneratorService seqService;


	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		room.setRoomId(seqService.getSequenceNumber(Room.SEQUENCE_NAME));
		List<Room> rooms = roomRepository.findAll();
		rooms.forEach(r -> {
			if (r.getRoomNo() == room.getRoomNo()) {
				throw new DuplicateEntryException(room.getRoomNo() + " is already present");
			}
		});

		return roomRepository.save(room);
	}

	@Override
	public Room updateRoom(Room room) {
		// TODO Auto-generated method stub
		Optional<Room> roomFound = roomRepository.findById(room.getRoomId());
		if (roomFound.isEmpty()) {
			throw new RoomNotFoundWithIdException("Room not found with Id " + room.getRoomId());
		}
//		List<Room> rooms = roomRepository.findAll();
//		rooms.forEach(r -> {
//			if (r.getRoomNo() == room.getRoomNo()) {
//				throw new DuplicateEntryException(room.getRoomNo() + " is already present");
//			}
//		});
		return roomRepository.save(room);
	}

	@Override
	public String deleteRoom(int id) {
		// TODO Auto-generated method stub
		Optional<Room> roomFound = roomRepository.findById(id);
		if (roomFound.isEmpty()) {
			throw new RoomNotFoundWithIdException("Room not found with Id " + id);
		}
		roomRepository.deleteById(id);

		return "Room deleted successfully with Id " + id;
	}

	@Override
	public List<Room> getRoomsAvail() {
		// TODO Auto-generated method stub
		 
		
	List<Room>	rooms=roomRepository.findByRoomAvail();
		if (rooms.isEmpty()) {
			throw new RoomsNotAvailableException("No rooms are available");
		}
		return rooms;
	}

	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
//		List<Room> rooms = roomRepository.findAll();
		
			List<Room> rooms=roomRepository.findAll();
		if (rooms.isEmpty()) {
			throw new RoomsNotAvailableException("No rooms are present in database");
		}
		return rooms;
	}

	@Override
	public Room findByRoomId(int id) {
		// TODO Auto-generated method stub

		Optional<Room> room = roomRepository.findById(id);
		if (room.isEmpty()) {
			throw new RoomNotFoundWithIdException("Room not found with Id " + id);
		}
		return room.get();
	}

	@Override
	public List<Room> findByRoomType(String roomType, String roomDesc) {
		// TODO Auto-generated method stub
		List<Room> listOfRooms=roomRepository.findRoomsByType(roomType, roomDesc);
		if(listOfRooms.isEmpty())
		{
			throw new RoomsNotAvailableException("Rooms are Not available "+roomType +" "+roomDesc);
		}
		return listOfRooms;
	}

	@Override
	public Room getByRoomNo(int number) {
		// TODO Auto-generated method stub
		Optional<Room> room=roomRepository.findByRoomNo(number);
		if(room.isEmpty())
		{
			throw new RoomNotFoundWithRoomNoException(" Room not found with Room No "+number);
		}
		return room.get();
	}
	public Room checkOut(int roomNo)
	{
		Optional<Room> room=roomRepository.findByRoomNo(roomNo);
		if(room.isEmpty())
		{
			throw new RoomNotFoundWithRoomNoException(" Room not found with Room No "+roomNo);
		}
		Room foundRoom=room.get();
		foundRoom.setRoomAvail(true);
		return roomRepository.save(foundRoom);
	}

}
