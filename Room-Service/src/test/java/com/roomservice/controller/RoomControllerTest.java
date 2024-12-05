package com.roomservice.controller;

import com.roomservice.entity.Room;
import com.roomservice.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class RoomControllerTest {

    @InjectMocks
    private RoomController roomController;

    @Mock
    private RoomService roomService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
    }

    @Test
    public void testGetByRoomId() throws Exception {
        int roomId = 1;
        Room room = new Room();
        when(roomService.findByRoomId(roomId)).thenReturn(room);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/find/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$").exists());

        verify(roomService, times(1)).findByRoomId(roomId);
    }

    @Test
    public void testFetchAllRooms() throws Exception {
        List<Room> roomList = List.of(new Room(), new Room());
        when(roomService.getAllRooms()).thenReturn(roomList);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(roomList.size()));

        verify(roomService, times(1)).getAllRooms();
    }

    

    @Test
    public void testFetchAllAvailableRooms() throws Exception {
        List<Room> roomList = List.of(new Room(), new Room());
        when(roomService.getRoomsAvail()).thenReturn(roomList);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/available"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(roomList.size()));

        verify(roomService, times(1)).getRoomsAvail();
    }

    @Test
    public void testGetByRoomNo() throws Exception {
        int roomNo = 1;
        Room room = new Room();
        when(roomService.getByRoomNo(roomNo)).thenReturn(room);

        mockMvc.perform(MockMvcRequestBuilders.get("/room/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$").exists());

        verify(roomService, times(1)).getByRoomNo(roomNo);
    }

    @Test
    public void testDoCheckOut() throws Exception {
        int roomNo = 1;
        Room room = new Room();
        when(roomService.checkOut(roomNo)).thenReturn(room);

        mockMvc.perform(MockMvcRequestBuilders.put("/room/checkout/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$").exists());

        verify(roomService, times(1)).checkOut(roomNo);
    }
}
