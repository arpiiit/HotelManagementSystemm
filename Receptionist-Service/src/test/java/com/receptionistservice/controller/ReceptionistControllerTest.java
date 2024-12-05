package com.receptionistservice.controller;

import com.receptionistservice.entity.Receptionist;
import com.receptionistservice.service.ReceptionistService;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class ReceptionistControllerTest {

    @InjectMocks
    private ReceptionistController receptionistController;

    @Mock
    private ReceptionistService receptionistService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(receptionistController).build();
    }

    @Test
    public void testFetchAllReceptionists() throws Exception {
        List<Receptionist> receptionistList = List.of(new Receptionist(), new Receptionist());

        // Define the behavior of receptionistService.getAllReceptionists() when the /receptionist/all endpoint is accessed
        when(receptionistService.getAllReceptionists()).thenReturn(receptionistList);

        mockMvc.perform(MockMvcRequestBuilders.get("/receptionist/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(receptionistList.size()));

        // Verify that receptionistService.getAllReceptionists() was called
        verify(receptionistService, times(1)).getAllReceptionists();
    }
}
