package com.ownerservice.service;

import com.ownerservice.models.Owner;
import com.ownerservice.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class OwnerServiceImplTest {

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddOwner() {
        Owner owner = new Owner();
        when(ownerRepository.save(owner)).thenReturn(owner);

        Owner addedOwner = ownerService.addOwner(owner);

        assertNotNull(addedOwner);
        assertEquals(owner, addedOwner);
    }

    @Test
    public void testGetAllOwners() {
        List<Owner> ownerList = List.of(new Owner(), new Owner());
        when(ownerRepository.findAll()).thenReturn(ownerList);

        List<Owner> retrievedOwners = ownerService.getAllOwners();

        assertNotNull(retrievedOwners);
        assertEquals(ownerList, retrievedOwners);
    }
}
