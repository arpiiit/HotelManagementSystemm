package com.inventoryservice.service;

import com.inventoryservice.entity.Inventory;
import com.inventoryservice.exception.InventoryNotFoundWithIdException;
import com.inventoryservice.repository.InventoryReposiotry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InventoryServiceTest{

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @Mock
    private InventoryReposiotry inventoryRepository;

    @Mock
    private SequenceGeneratorService seqService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveInventory() {
        Inventory inventory = new Inventory();
        when(seqService.getSequenceNumber(Inventory.SEQUENCE_NAME)).thenReturn((int) 1L);
        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory savedInventory = inventoryService.saveInventory(inventory);

        assertNotNull(savedInventory);
        assertEquals(1L, savedInventory.getInventoryId());
    }

    @Test
    public void testModifyInventory() {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(1);

        when(inventoryRepository.findById(1)).thenReturn(Optional.of(inventory));
        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory modifiedInventory = inventoryService.modifyInventory(inventory);

        assertNotNull(modifiedInventory);
        assertEquals(1, modifiedInventory.getInventoryId());
    }

    @Test
    public void testModifyInventoryNotFound() {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(1);

        when(inventoryRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(InventoryNotFoundWithIdException.class, () -> inventoryService.modifyInventory(inventory));
    }

    @Test
    public void testRemoveInventory() {
        int inventoryId = 1;
        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.of(new Inventory()));

        String result = inventoryService.removeInventory(inventoryId);

        assertNotNull(result);
        assertEquals("Inventory deleted successfully with ID " + inventoryId, result);
        verify(inventoryRepository, times(1)).deleteById(inventoryId);
    }

    @Test
    public void testRemoveInventoryNotFound() {
        int inventoryId = 1;
        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.empty());

        assertThrows(InventoryNotFoundWithIdException.class, () -> inventoryService.removeInventory(inventoryId));
    }

    @Test
    public void testGetByInventoryId() {
        int inventoryId = 1;
        Inventory inventory = new Inventory();
        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.of(inventory));

        Inventory retrievedInventory = inventoryService.getByInventoryId(inventoryId);

        assertNotNull(retrievedInventory);
        assertEquals(inventory, retrievedInventory);
    }

    @Test
    public void testGetByInventoryIdNotFound() {
        int inventoryId = 1;
        when(inventoryRepository.findById(inventoryId)).thenReturn(Optional.empty());

        assertThrows(InventoryNotFoundWithIdException.class, () -> inventoryService.getByInventoryId(inventoryId));
    }

    @Test
    public void testGetAllInventories() {
        List<Inventory> inventoryList = List.of(new Inventory(), new Inventory());
        when(inventoryRepository.findAll()).thenReturn(inventoryList);

        List<Inventory> retrievedInventories = inventoryService.getAllInventories();

        assertNotNull(retrievedInventories);
        assertEquals(inventoryList, retrievedInventories);
    }
}
