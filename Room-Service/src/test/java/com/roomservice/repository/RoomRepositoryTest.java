package com.roomservice.repository;

import com.roomservice.entity.Room;
import com.roomservice.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
public class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        // Clear the collection before each test
        mongoTemplate.remove(new Query(), Room.class);
    }

    @Test
    public void testFindByRoomAvail() {
        // Create available and unavailable rooms
        Room availableRoom1 = new Room();
        Room availableRoom2 = new Room();
        Room unavailableRoom = new Room();

        List<Room> availableRooms = roomRepository.findByRoomAvail();

    }

    @Test
    public void testFindRoomsByType() {
        // Create rooms of different types and availability
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();

        List<Room> singleAvailableRooms = roomRepository.findRoomsByType("Single", "Room 1");

      
    }

    @Test
    public void testFindByRoomNo() {
        // Create rooms with different room numbers
        Room room1 = new Room();
        Room room2 = new Room();

        Optional<Room> foundRoom = roomRepository.findByRoomNo(room2.getRoomNo());

       
    }

    @Test
    public void testFindByRoomNoNonExistent() {
        // Try to find a non-existent room by room number
        Optional<Room> foundRoom = roomRepository.findByRoomNo(999);

        assertTrue(foundRoom.isEmpty());
    }
}
