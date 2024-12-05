package com.roomservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.roomservice.entity.Room;

public interface RoomRepository extends MongoRepository<Room, Integer> {
	@Query("{roomAvail:true}")
	List<Room> findByRoomAvail();
	
	@Query("{roomType:'?0', roomDesc:'?1', roomAvail:true}")
	List<Room> findRoomsByType(String roomType, String roomDesc);
	
	@Query("{roomNo:?0}")
	Optional<Room> findByRoomNo(int roomNo);
}
