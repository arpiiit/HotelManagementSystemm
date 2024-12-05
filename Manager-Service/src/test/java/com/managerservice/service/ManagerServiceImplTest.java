package com.managerservice.service;

import com.managerservice.entity.Manager;
import com.managerservice.repository.ManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ManagerServiceImplTest {

    @InjectMocks
    private ManagerServiceImpl managerService;

    @Mock
    private ManagerRepository managerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddManager() {
        Manager manager = new Manager();
        when(managerRepository.save(manager)).thenReturn(manager);

        Manager savedManager = managerService.addManager(manager);

        assertNotNull(savedManager);
        assertEquals(manager, savedManager);
    }

    @Test
    public void testGetAllManagers() {
        List<Manager> managerList = List.of(new Manager(), new Manager());
        when(managerRepository.findAll()).thenReturn(managerList);

        List<Manager> retrievedManagers = managerService.getAllManagers();

        assertNotNull(retrievedManagers);
        assertEquals(managerList, retrievedManagers);
    }
}

