package com.inventoryservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

import com.inventoryservice.entity.Inventory;
import com.inventoryservice.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
public class InventoryRepositoryTest {

    @Autowired
    private InventoryReposiotry inventoryRepository;

    @Test
    public void testSaveInventory() {
        Inventory inventory = new Inventory();
        // Set inventory properties here
//        Inventory savedInventory = inventoryRepository.save(inventory);
//        assertNotNull(savedInventory.getInventoryId());
    }

    @Test
    public void testFindById() {
        Inventory inventory = new Inventory();
        // Set inventory properties here
//        Inventory savedInventory = inventoryRepository.save(inventory);

//        Optional<Inventory> foundInventory = inventoryRepository.findById(savedInventory.getInventoryId());
//        assertTrue(foundInventory.isPresent());
//        assertEquals(savedInventory.getInventoryId(), foundInventory.get().getInventoryId());
    }


    @Test
    public void testDeleteInventory() {
        Inventory inventory = new Inventory();
        // Set inventory properties here
//        Inventory savedInventory = inventoryRepository.save(inventory);

//        inventoryRepository.deleteById(savedInventory.getInventoryId());
//        Optional<Inventory> foundInventory = inventoryRepository.findById(savedInventory.getInventoryId());
//        assertFalse(foundInventory.isPresent());
    }
}
