package com.roomservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.roomservice.entity.Room;
import com.roomservice.entity.RoomList;
import com.roomservice.exception.RoomNotFoundWithIdException;
import com.roomservice.repository.RoomRepository;
import com.roomservice.service.RoomService;
import com.roomservice.service.RoomServiceImpl;

@SpringBootTest
public class RoomServiceTest {

	@InjectMocks
	private RoomService roomService = new RoomServiceImpl();

	@Mock
	private RoomRepository roomRepository;

	
	@Test
	void testDeleteRoom() {
		Room room = new Room();
		room.setRoomId(2);
		room.setRoomNo(201);
		room.setRoomType("Double Bed");
		room.setRoomDesc("With A/C");
		room.setRoomPrice(1700);
		room.setRoomAvail(true);
		Optional<Room> optionalRoom = Optional.of(room);
		when(roomRepository.findById(2)).thenReturn(optionalRoom);
		roomService.deleteRoom(2);
		verify(roomRepository, times(1)).findById(2);
		verify(roomRepository, times(1)).deleteById(2);
	}
	@Test
	void testViewRoomById()
	{
		Room room = new Room();
		room.setRoomId(2);
		room.setRoomNo(201);
		room.setRoomType("Double Bed");
		room.setRoomDesc("With A/C");
		room.setRoomPrice(1700);
		room.setRoomAvail(true);
		Optional<Room> optionalRoom = Optional.of(room);
		when(roomRepository.findById(2)).thenReturn(optionalRoom);
		Room room1=roomService.findByRoomId(2);
		assertEquals(201, room1.getRoomNo());
	}
	@Test
	void testUpdateRoom()
	{
		Room room = new Room();
		room.setRoomId(2);
		room.setRoomNo(201);
		room.setRoomType("Double Bed");
		room.setRoomDesc("With A/C");
		room.setRoomPrice(1700);
		room.setRoomAvail(true);
		Optional<Room> optionalRoom = Optional.of(room);
		when(roomRepository.findById(2)).thenReturn(optionalRoom);
		roomService.updateRoom(room);
		verify(roomRepository, times(1)).findById(2);
		verify(roomRepository, times(1)).save(room);
		
	}
	@Test
	void testRoomIdException()
	{
		Room room = new Room();
		room.setRoomId(2);
		room.setRoomNo(201);
		room.setRoomType("Double Bed");
		room.setRoomDesc("With A/C");
		room.setRoomPrice(1700);
		room.setRoomAvail(true);
		when(roomRepository.findById(3)).thenThrow(RoomNotFoundWithIdException.class);
		assertThrows(RoomNotFoundWithIdException.class, ()-> roomService.findByRoomId(3));
	}
	
}
