package com.ownerservice.controller;

import com.ownerservice.models.Owner;
import com.ownerservice.service.OwnerService;
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

public class OwnerControllerTest {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerService ownerService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    public void testFetchAllOwner() throws Exception {
        List<Owner> ownerList = List.of(new Owner(), new Owner());

        // Define the behavior of ownerService.getAllOwners() when the /owner/all endpoint is accessed
        when(ownerService.getAllOwners()).thenReturn(ownerList);

        mockMvc.perform(MockMvcRequestBuilders.get("/owner/all"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(ownerList.size()));

        // Verify that ownerService.getAllOwners() was called
        verify(ownerService, times(1)).getAllOwners();
    }
}
