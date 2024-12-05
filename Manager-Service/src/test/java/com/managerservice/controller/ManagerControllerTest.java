package com.managerservice.controller;

import com.managerservice.entity.Manager;
import com.managerservice.service.ManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class ManagerControllerTest {

    @InjectMocks
    private ManagerController managerController;

    @Mock
    private ManagerService managerService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(managerController).build();
    }

    @Test
    public void testFetchAllManagers() throws Exception {
        List<Manager> managerList = List.of(new Manager(), new Manager());

        // Define the behavior of managerService.getAllManagers() when the /all endpoint is accessed
        when(managerService.getAllManagers()).thenReturn(managerList);

        mockMvc.perform(get("/manager/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(managerList.size()));

        // Verify that managerService.getAllManagers() was called
        verify(managerService, times(1)).getAllManagers();
    }

    @Test
    public void testFetchAllManagersNoManagersFound() throws Exception {
        // Define the behavior of managerService.getAllManagers() when no managers are found
        when(managerService.getAllManagers()).thenReturn(List.of());

        mockMvc.perform(get("/manager/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));

        // Verify that managerService.getAllManagers() was called
        verify(managerService, times(1)).getAllManagers();
    }
}
