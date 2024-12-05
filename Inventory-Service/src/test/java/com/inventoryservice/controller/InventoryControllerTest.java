package com.inventoryservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventoryservice.entity.Inventory;
import com.inventoryservice.service.InventoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddInventory() throws Exception {
        Inventory inventory = new Inventory();
        // Set your inventory properties here

        mockMvc.perform(MockMvcRequestBuilders
                .post("/inventory/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inventory)))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void testFetchAllInventories() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/inventory/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}

